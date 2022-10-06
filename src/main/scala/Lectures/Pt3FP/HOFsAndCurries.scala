package Lectures.Pt3FP

import scala.annotation.tailrec

object HOFsAndCurries extends App {
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // higher order function (HOF)

  // map, flatMap, filter in MyList

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // ntb(f,n) = x => f(f(f...(x)))
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // curried functions
  def superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /* EXERCISES
    1. Extend MyList
      -forEach method A => Unit
        [1,2,c].forEach(x => println()) => Unit
      -sort method ((A,A) => Int ) => MyList
        [1,2,c].sort((x,y) => y-x) => [3,2,1]
      -zipWith (list, (A, A) => B) => MyList[B]
        [1,2,c].zipWith([4,5,6], x * y) => [1*4, 2*5, 3*6] = [4,10,18]
      -fold (curried)
        [1,2,3].fold(0)(x+y) => 0 + 1 + 2 + 3 = 6

    2. toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
       fromCurry(Int => Int => Int) => ((Int, Int) => Int)

    3. compose(f, g) => x =>  f(g(x))
       andThen(f,g) => x => g(f(x))
  */

  def toCurry[A, B, C](f: (A, B) => C): (A => B => C) =
    x => y => f(x, y)

  def fromCurry[A, B, C](f: (A => B => C)): (A, B) => C =
    (x, y) => f(x)(y)

  def compose[A, B, C](f: A => B, g: C => A): C => B =
    x => f(g(x))

  def andThen[A, B, C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def supperAdder2: Int => Int => Int = toCurry(_ + _)

  def add4 = supperAdder2(4)

  val simpleAdder = fromCurry(superAdder)


  println(add4(17))
  println(simpleAdder(4, 17))
}
