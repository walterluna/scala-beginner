package Lectures.Pt1Basics

import scala.annotation.tailrec

object Recursion extends App {
  //  This kind of recursion keeps on adding to call stack and consumes a lot of memory
  //  potentially results in stack overflow
  def factorial(num: Int): Int = {
    if (num <= 0) 1
    else {
      println("Computing factorial of : " + num + " - First I need factorial of " + (num - 1))
      val result = num * factorial(num - 1)
      println("Computed factorial of " + num)
      result
    }
  }

  //  TAIL RECURSION
  //  we use recursive calls as the last expressions
  def tailFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, acc: BigInt): BigInt = {
      if (x <= 1) acc
      else factHelper(x - 1, acc * x)
    }

    factHelper(n, 1)
  }

  println(factorial(10))

  println(tailFactorial(20000))

  //  When we need loops, we use TAIL recursion

  /* EXERCISES
    1. Concatenate a string n times
    2. isPrime function
    3. fibonacci function
   */

  def concatString(text: String, n: Int): String = {
    @tailrec
    def concatHelper(n: Int, acc: String): String = {
      if (n <= 1) acc + text
      else concatHelper(n - 1, acc + text)
    }

    concatHelper(n, "")
  }

  def isPrime(x: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int): Boolean = {
      if (t <= 1) true
      else if (x % t == 0) false
      else isPrimeHelper(t - 1)
    }

    isPrimeHelper(x / 2)
  }

  def fibonacci(x: Int): Int = {
    @tailrec
    def fibHelper(n: Int, acc1: Int, acc2: Int): Int = {
      if (n == x) acc1
      else fibHelper(n + 1, acc1 + acc2, acc1)
    }

    fibHelper(1, 1, 0)
  }

  println("Fibonacci")
  println("1 " + fibonacci(1))
  println("2 " + fibonacci(2))
  println("3 " + fibonacci(3))
  println("4 " + fibonacci(4))
  println("5 " + fibonacci(5))
  println("6 " + fibonacci(6))
  println("7 " + fibonacci(7))
  println("8 " + fibonacci(8))


  println("isPrime")
  println(isPrime(10))
  println(isPrime(23))
  println(isPrime(7))
  println(isPrime(31))

  println("String concat")
  println(concatString("hello", 3))
}
