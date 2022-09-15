package Lectures.Pt2OOP

import scala.language.postfixOps

object Notations extends App {
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = this.favoriteMovie == movie

    def hangOutWith(person: Person) = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name what the heck!?"

    def isAlive: Boolean = true

    def apply(): String = s"Hi  my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  //  Infix notation, for methods with one param (syntactic sugar)
  println(mary likes "Inception")

  //  "Operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary.hangOutWith(tom))
  println(mary hangOutWith tom)
  println(1 + 2)
  println(1.+(2))

  //  All operators are methods

  //  Prefix notation (Syntactic sugar) unary operators
  val x = -1
  val y = 1.unary_-
  //  unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  //  Postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //  apply
  println(mary.apply())
  println(mary())

}
