package Exercises

import Lectures.Pt2OOP.Generics.MyList

import scala.annotation.{tailrec, targetName}
import scala.runtime.Nothing$

abstract class MyList[+A] {

  /*
  single linked list of ints
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(integer) => new list with this element added
  toString => a String representation of the list
   */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "{ " + printElements + " }"

  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  //  HOFs
  def forEach(f: A => Unit): Unit

  def sort(f: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](acc: B)(folder: (A, B) => B): B
}


case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()

  def tail: MyList[Nothing] = throw new NoSuchElementException()

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = Cons(element, Empty)

  override def printElements: String = ""

  //  map, flatMap and filter are higher-order functions (HOF)
  //  this means they receive or return functions
  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  //  HOFs
  def forEach(f: Nothing => Unit): Unit = ()
  //  () is equivalent to Unit

  override def sort(f: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists are not same sized")
    else Empty

  override def fold[B](acc: B)(folder: (Nothing, B) => B): B = acc
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = Cons(element, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
  }

  def map[B](transformer: A => B): MyList[B] =
    Cons(transformer(head), t.map(transformer))


  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(head) ++ t.flatMap(transformer)

  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(head)) Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)

  //  HOFs
  override def forEach(f: A => Unit): Unit =
    f(head)
    tail.forEach(f)

  //  Implementation of bubble sort (Mine)
  override def sort(compare: (A, A) => Int): MyList[A] =
    if (tail.isEmpty) Cons(head, Empty)
    else if (compare(head, tail.head) > 0) Cons(tail.head, Cons(head, tail.tail).sort(compare)).sort(compare)
    else Cons(head, tail)

  //  Implementation of insert sort (from video) (ex: try making it tailRec)
  // override def sort(compare: (A, A) => Int): MyList[A] = {
  //   def insert(x: A, sortedList: MyList[A]): MyList[A] =
  //     if (sortedList.isEmpty) Cons(x, Empty)
  //     else if (compare(x, sortedList.head) <= 0) Cons(x, sortedList)
  //     else Cons(sortedList.head, insert(x, sortedList.tail))
  //   val sortedTail = tail.sort(compare)
  //   insert(h, sortedTail)
  // }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists are not same sized")
    else Cons(zip(head, list.head), tail.zipWith(list.tail, zip))

  override def fold[B](acc: B)(folder: (A, B) => B): B =
    tail.fold(folder(head, acc))(folder)
}

object ListTest extends App {
  //  val list =  Cons(1,  Cons(2,  Cons(3, Empty)))
  //  println(list.tail.head)
  //  println(list.add(4).head)
  //  println(list.isEmpty)
  //
  //  println(list.toString)

  val listOfIntegers: MyList[Int] = Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Empty)))))
  val listOfIntegersClone: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = Cons(4, Cons(5, Empty))
  val listOfStrings: MyList[String] = Cons("hello", Cons("scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(_ * 2).toString)

  println(listOfIntegers.filter(_ % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap((elem) => Cons[Int](elem, Cons[Int](elem + 1, Empty))))

  println(listOfIntegers == listOfIntegersClone)

  println("HOF and Curries exercises")
  listOfIntegers.forEach(println)
  println(listOfIntegers.sort((x, y) => y - x).toString)
  println(listOfStrings.zipWith[Int, String](anotherListOfIntegers, _ + "-" + _))
  val foldOnZero = listOfIntegersClone.fold(0)
  val foldOnTen = listOfIntegersClone.fold(10)
  println(foldOnZero(_ + _))
  println(foldOnTen(_ + _))
}