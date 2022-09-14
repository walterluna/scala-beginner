package Lectures.Pt1Basics

object StringOps extends App {
  val aStr: String = "Hello, I am learning Scala"

  // These are all java functions that become available in Scala
  println(aStr.charAt(2))
  println(aStr.substring(7, 11))
  println(aStr.split(" ").toList)
  println(aStr.startsWith("Hello"))
  println(aStr.replace(" ", "-"))
  println(aStr.toLowerCase())
  println(aStr.toUpperCase())
  println(aStr.length)

  //  Scala's own utilities
  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(aNumber)
  // +: concat at the beginning of the string
  // :+ concat at the end of the string
  println("z" :+ aNumberString +: "a")
  println(aStr.reverse)
  println(aStr.take(2))

  //  S interpolator
  val name = "Walter"
  val age = 25
  val greeting = s"Hi, my name is $name and I'm $age years old"
  val anotherGreeting = s"Hi, my name is $name and I'll be  ${age + 1} years old next year"
  println(greeting)
  println(anotherGreeting)

  //  F interpolator (similar to printf)
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burger per minute"
  println(myth)

  //  raw interpolator (escaped chars are printed with escape character)
  val rawString = "Hi \n new line"
  println(raw"Hi \n new line")
  println(raw"$rawString")
}
