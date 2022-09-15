package Lectures.Pt2OOP

object Objects extends App {
  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")

  // An object can have val, vars and methods
  // Objects do not receive params
  object Person {
    // static level
    val N_EYES = 2

    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    // Instance level
  }
  //  Scala objects are used as singletons (by definition)
  //  It is common practice to create objects and classes on the same scope
  //  This is to separate instance functionality from static || class functionality
  //  This practice is called companions, object and class are companions

  println(Person.N_EYES)
  println(Person.canFly)

  val mary = new Person("mary")
  val john = new Person("john")

  val bobby = Person(mary, john)

  //  Scala applications = scala object with
  //  def main(args: Array: [String]): Unit
  //  equivalent to public static void main(args: String[])
  //  All code in an extends App object is wrapped in this ^ function

}
