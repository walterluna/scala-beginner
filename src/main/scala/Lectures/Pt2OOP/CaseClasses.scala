package Lectures.Pt2OOP

object CaseClasses extends App {
  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  //  1. class params are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  //  2. sensible toString
  println(jim.toString)
  //  println(jim) is equal (syntactic sugar)

  //  3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  //  4. Case classes have copy method
  val jim3 = jim.copy()
  val jim4 = jim.copy(age = 35)
  //  they accept named params to overwrite specific fields
  println(jim3)
  println(jim4)

  //  5. Case classes have companion objects
  val thePerson = Person
  //  factory methods (apply method)
  val mary = Person("Mary", 23)

  //  6. Case classes are serializable
  // useful for Akka

  //  7. Case classes have extractor patterns
  //  So they can be used in pattern matching

  //  There are also companion objects
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Exercises:
  Expand MyList - use case classes and case objects
   */

}
