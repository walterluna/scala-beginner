package Lectures.Pt2OOP

object AbstractDataTypes extends App {
  //  Abstract members are fields or methods that are needed to be unimplemented
  //  classes with abstract members are called abstract classes using "abstract" keyboard
  //  abstract classes cannot be instantiated

  abstract class Animal {
    val creatureType: String

    def eat(): Unit
  }

  class Dog extends Animal {
    val creatureType: String = "Canine"

    override def eat(): Unit = println("crunch crunch")
  }

  //  Traits
  //  they can be inherited along classes
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait coldBlooded

  class Crocodile extends Animal with Carnivore with coldBlooded {
    val creatureType = "croc"

    override def eat(): Unit = {
    }

    override def eat(animal: Animal): Unit = println(s"I'm a croc an I'm eating ${animal.creatureType}")
  }

  val dog = new Dog()
  val croc = new Crocodile()

  croc.eat(dog)

  //  Traits vs abstract classes
  //  both allow abstract and non abstract members
  //  traits cant have constructor parameters
  //  you can only extend one class. you can extend multiple traits
  //  traits describe behavior, abstract class describe things


  //  Scala type hierarchy
  /*
                                 scala.Any
                          /                    \
           scala.anyVal                          scala.AnyRef (java.lang.Object)
    (Int, Unit, Boolean, etc..)                    (User defined classes, String, List, Set,etc)
                          \                                  \       |       /
                             \                                 scala.Null
                               \                            /
                                      scala.Nothing
   */
}
