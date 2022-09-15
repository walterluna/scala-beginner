package Lectures.Pt2OOP

import scala.language.postfixOps

object Notations extends App {
  class Person(val name: String, favoriteMovie: String, age: Int) {
    def likes(movie: String): Boolean = this.favoriteMovie == movie

    def hangOutWith(person: Person) = s"${this.name} is hanging out with ${person.name}"

    def learns(topic: String): String = s"$name learns $topic"

    def learnsScala(): String = this learns ("Scala")

    def unary_! : String = s"$name what the heck!?"

    def +(nickname: String): Person = new Person(s"${this.name} ($nickname)", this.favoriteMovie, this.age)


    def isAlive: Boolean = true

    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

    def apply(): String = s"Hi  my name is $name, I like $favoriteMovie and I am $age years old"

    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception", 25)
  println(mary.likes("Inception"))
  //  Infix notation, for methods with one param (syntactic sugar)
  println(mary likes "Inception")

  //  "Operators" in scala
  val tom = new Person("Tom", "Fight Club", 29)
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
  println(!mary)

  //  Postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //  apply
  println(mary.apply())
  println(mary())

  /* EXERCISES
  1. Overload the + operator
    mary + "the rockstar => "Mary (the rockstar)"

  2. Add age to the person class
     Overload + operator => new person with age +=1

  3. Add a "learns" method in the person class
  (string) => Mary learns (param)
  add learn scala method, class learns with "Scala"
  use it in postfix notation

  4. Overload the apply method
  mary apply 2 => "Mary watched Inception 2 times"
   */
  val rockstar = mary + "the rockstart"
  println(rockstar())

  val olderRockstar = +rockstar;
  println(olderRockstar())

  println(mary learns "martial arts")
  println(mary learnsScala)

  println(mary(5))
}
