package Lectures.Pt2OOP

import java.time.LocalDate

object OOPExercises extends App {
  /*
    1. Novel and a writer
    Writer: firstName. surname, year
      -methods: fullName()

    Novel: name, year of release, author
      -authorAge
      -isWrittenBy()
      -copy(newYearOfRelease): Novel
   */
  val uncleBob = new Writer("Robert C.", "Martin", 1952)
  val coAuthor = new Writer("James", "Greening", 1963)
  println(uncleBob.fullName())

  val cleanArchitecture = new Novel("Clean Architecture", 2018, uncleBob)

  println(cleanArchitecture)
  println(cleanArchitecture.authorAge())

  val cleanArchitectureNewEdition = cleanArchitecture.copy(2022)
  println(cleanArchitectureNewEdition)
  println(cleanArchitectureNewEdition.isWrittenBy(uncleBob))
  println(cleanArchitectureNewEdition.isWrittenBy(coAuthor))
  println(cleanArchitectureNewEdition.authorAge())
  /*
    Counter class
      -receives an int value
      -method current count
      -method to increment/decrement => new Counter
      -overload inc/dec to receive an amount to inc/dec => new Counter
   */
}

class Writer(firstName: String, surName: String, val year: Int) {
  def fullName(): String = s"$firstName $surName"
}

class Novel(name: String, year: Int, var author: Writer) {
  def authorAge(): Int = LocalDate.now().getYear - this.author.year

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)
}

class Counter(val count: Int) {
  def increment: Counter = new Counter(this.count + 1) // immutability

  def decrement: Counter = new Counter(this.count - 1)

  def increment(n: Int): Counter = new Counter(this.count + n)

  def decrement(n: Int): Counter = new Counter(this.count - n)
}