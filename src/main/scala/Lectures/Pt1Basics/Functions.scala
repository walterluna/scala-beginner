package Lectures.Pt1Basics

object Functions extends App {
  //  Function return type can be inferred by the compiler
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParamLessFunction(): Int = 42

  println(aParamLessFunction())

  //  When we need loops, we use recursion
  //  Recursive functions need to explicitly define return types
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }

  aFunctionWithSideEffects("Hello there")

  //  Functions can be defined inside other functions
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  //  Exercises
  /* * EXERCISES
  1. A greeting function (name, age)
  2. Factorial function
  3. Fibonacci function
  4. isPrime function
   */

  def greeting(name: String, age: Int): Unit = {
    println("Hello, my name is " + name + " and I'm " + age + " years old");
  }

  def factorial(num: Int): Int = {
    if (num <= 0) 1
    else num * factorial(num - 1)
  }

  def fibonacci(num: Int): Int = {
    if (num == 1 || num == 2) 1
    else fibonacci((num - 1)) + fibonacci(num - 2)
  }

  def isPrime(num: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else num % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(num / 2)
  }

  greeting("walter", 25)

  println(factorial(4))

  println(fibonacci(3))
  println(fibonacci(4))
  println(fibonacci(5))

  println(isPrime(7))
  println(isPrime(11))
  println(isPrime(7 * 11))


}
