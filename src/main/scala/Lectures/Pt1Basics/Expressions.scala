package Lectures.Pt1Basics

object Expressions extends App {
  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4) //Math expressions
  //  + - *  / % & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  //  == != > >= < <=

  println(!(1 == x))
  //  ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ........ side effects
  println(aVariable)

  //  Instructions vs Expressions
  //  An instruction is something you tell the computer to do
  //  An expressions is something that resolves to a value and/or has a type

  //  IF expressions
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3

  println(aConditionedValue)

  //  loops
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  //  not the way we will use to iterate in the future

  //  everything in scala is an expression (except definitions)

  //  type unit is equivalent to void in other languages
  val aWeirdValue: Unit = (aVariable = 3)
  println(aWeirdValue)

  //  code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)

  //  a code block expressions resolves to the last expression inside it
  //  definitions inside a code block are only available inside the code block

  /* EXERCISES

  1. difference between "hello world" vs println("hello world")
  2. Whats the value of the following code block?
  val someValue = {
    2 < 3
  }
  3. Whats the value of
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

  ANSWERS
  1. "hello world" is an  expression returning a string, println("hello world") is a side effect returning Unit
  2. true (boolean)
  3. 42 (int)
   */

}
