package Lectures.Pt2OOP

object Exceptions extends App {
  //  This is jvm specific
  val x: String = null
  //  println(x.length)
  //  ^^ this crashes with ExceptionInInitializerError

  //  exceptions are thrown and caught
  //  throwing an exception is an expression, it returns "Nothing"

  //  1. Throwing exceptions
  //  throw new NullPointerException()
  //  Exceptions are Objects, that's why we use the "new" keyword
  //  Throwable classes extends Throwable
  //  Exceptions and Error are the major Throwable subtypes


  //  2. Catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  try {
    //  code that might fail
    getInt(true)
  }
  catch {
    case e: RuntimeException => println("caught a runtime exception")
  } finally {
    //  code that will get executed no matter what
    println("finally")
  }

  //  try catch finally is an expression, as everything
  //  the type of this expression is inferred by the compiler
  //  finally does not influence the return of the expression
  //  it should be used only for side effects (logging, etc)

  //  3. Custom exceptions
  class MyException extends Exception

  val exc = new MyException
  //  throw exc

  /* Exercises
    1. crash program with an OutOfMemoryError
    2. Crash with StackOverflowError
    3. Create a PocketCalculator
      -add(x,y)
      -subtract(x,y)
      -multiply(x,y)
      -divide(x,y)

    Throw
      -OverflowException if add(x,y) exceeds Int.MAX_VALUE
      -UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
      -MathCalculationException for division by 0
  */

  //  1
  //  Array.ofDim(Int.MaxValue)

  //  2
  //  stack overflow can be thrown using an infinite recursive function

  //  3
  class OverflowException extends Exception

  class UnderflowException extends Exception

  class MathCalculationException extends Exception

  object PocketCalculator {
    def add(x: Int, y: Int): Int =
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result

    def subtract(x: Int, y: Int): Int =
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    def multiply(x: Int, y: Int): Int =
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result < 0) throw new OverflowException
      else if (x > 0 && y > 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result

    def divide(x: Int, y: Int): Int =
      if (y == 0) throw new MathCalculationException
      else x / y


  }

  //  println(PocketCalculator.add(Int.MaxValue, 10))
  //  println(PocketCalculator.divide(534, 0))
}
