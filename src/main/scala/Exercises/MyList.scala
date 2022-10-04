package Exercises

import scala.annotation.targetName

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

}

object ListTest extends App {
  //  val list =  Cons(1,  Cons(2,  Cons(3, Empty)))
  //  println(list.tail.head)
  //  println(list.add(4).head)
  //  println(list.isEmpty)
  //
  //  println(list.toString)

  val listOfIntegers: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val listOfIntegersClone: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = Cons(1, Cons(4, Cons(5, Empty)))
  val listOfStrings: MyList[String] = Cons("hello", Cons("scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(_ * 2).toString)

  println(listOfIntegers.filter(_ % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap((elem) => Cons[Int](elem, Cons[Int](elem + 1, Empty))))

  println(listOfIntegers == listOfIntegersClone)
}