package Lectures.Pt3FP

object WhatsAFunction extends App {
  //  Dream: use and work with functions as 1st class elements
  //  Problem: we come from OOP, this is how jvm was designed

  // Scala does this by using functions as jvm objects

  trait MyFunction[A, B] {
    def apply(element: A): B
  }

  //  This function, is an object of MyFunction, a user defined trait
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  // Scala offers its own set of traits depending on the number of params,
  // From Function1[A,B] for A as 1st input type and B as Output
  // To Function22[A,B,C..,Z] accepting 22 param types
  //  There is syntactic sugar for these types
  //  e.g Function2[A,B,C] === (A,B) => C

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  println(doubler(4))
  println(adder(3, 7))

  //  ALL SCALA FUNCTIONS ARE JVM OBJECTS
  /* EXERCISES
  1. a function which takes 2 strings and concatenates them
  2. transform the MyPredicate and MyTransformer into function types
  3. define a function which takes an int and returns another function which takes an int and returns an int
    -what's the type of this function
    -how to do it
  */

  //  Ex1
  val stringConcatenation = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  //  Ex2
  //  This practice is called currying => Haskell Curry
  val curryAdder: Int => (Int => Int) = new Function1[Int, (Int) => Int] {
    override def apply(v1: Int): Int => Int = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  println(stringConcatenation("hello ", "world!"))
  println(curryAdder(1)(2))
}
