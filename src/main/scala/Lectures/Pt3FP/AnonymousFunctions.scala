package Lectures.Pt3FP

object AnonymousFunctions extends App {

  //  Anonymous function or lambda
  val doubler = (x: Int) => x * 2

  //  multiple params in lambda
  val multiplier: (Int, Int) => Int = (a, b) => a * b

  //  no params in lambda
  val justDoSomething: () => Int = () => 3

  //  If we defined the type of doubler as Int => Int,
  //  the implementation does not need the the parameter types e.g (x:Int)

  println(justDoSomething)
  println(justDoSomething())

  //  Lambdas must always be called with parenthesis

  //  curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //    More syntactic sugar
  val normalIncrementer: Int => Int = (x) => x + 1
  val niceIncrementer: Int => Int = _ + 1

  val normalAdder: (Int, Int) => Int = (a, b) => a + b
  val niceAdder: (Int, Int) => Int = _ + _

  //    This ^^ syntactic sugar depends on functions types being defined

  /* EXERCISES
  1. MyList: replace FunctionX calls with lambdas
  2. Rewrite the curried adder from last lesson as a lambda
  */

  //    Ex2
  val curryAdder = (a: Int) => (b: Int) => a + b
  println(curryAdder(2)(5))
}
