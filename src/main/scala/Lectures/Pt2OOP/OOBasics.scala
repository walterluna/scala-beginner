package Lectures.Pt2OOP

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)

  person.greet()
  person.greet("Daniel")

}

//constructor
class Person(name: String, val age: Int) {
  //  class' body, defines implementation of a class
  //  val and var definition (fields)
  //  function definitions
  //  expressions
  //  other definitions
  //  the value of the body (last exp) is ignored

  def greet(name: String): Unit = println(s"${this.name} says: hi $name")

  //  Function overload
  def greet(): Unit = println(s"Hi, I'm $name")

  //  Multiple constructors (constructor overloading)
  def this(name: String) = this(name, 0)
}
// Class parameters are NOT fields
// Add val keyword to make it a field