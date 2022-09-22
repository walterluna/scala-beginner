package Lectures.Pt2OOP

object Generics extends App {
  //  this is a generic class
  class MyList[A] {
    //    use type A inside
  }

  //  We can use multiple generics in a class
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //  Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInts = MyList.empty[Int]

  //  variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  //  Does List[Cat] extends List[Animal]
  //  1. Yes, with covariance
  class CovariantList[+A]

  //  +A means its a covariant list
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //  can I add a dog to this list? ^^^


  //  2. NO, Invariant list
  class InvariantList[A]

  val invarianAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  //  val invarianAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  //  compiler complains if we try to to that ^^^

  //  3. Hell no,CONTRAVARIANT LIST
  class Trainer[-A]

  val trainerList: Trainer[Cat] = new Trainer[Animal]
  //  val otherTrainerList: Trainer[Animal] = new Trainer[Cat]
  //This ^^ is not allowed, parent can stand in for son, but not the other way

  //  Bounded types
  //  generic can only be a specified class or its subclasses
  //  use <: operator
  class Cage[A <: Animal](animal: A)

  //  val cage = new Cage(new Dog)

  /* Exercises
    1. Extend list class to be generic
   */


}
