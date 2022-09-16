package Lectures.Pt2OOP

object InheritanceAndTraits extends App {

  //  Single class inheritance (you can only extend one class)
  //  private methods can only be called from the parent class
  //  protected methods can be called from parent and sub class
  //  public methods can be called from anywhere
  class Animal {
    val creatureType = "wild"

    protected def eat: Unit = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch: Unit = {
      eat
      println("crunch crunch crunch")
    }
  }

  val cat = new Cat()
  cat.crunch


  //  constructors
  class Person(name: String, age: Int)

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //  overriding
  class Dog(override val creatureType: String) extends Animal {
    //    override val creatureType: String = "Domestic"

    override def eat(): Unit = {
      super.eat
      println("crunch crunch crunch")
    }
  }

  //  class Dog(dogType: String) extends Animal {
  //    override val creatureType: String = dogType
  //  }

  val dog = new Dog("k9")
  dog.eat()
  println(dog.creatureType)

  //  typ substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("k9")

  //  super
  //  used to reference the method or field from parent class

  //  preventing overrides
  //  1. Use "final" keyword on method or field
  //  2. Use "final" on class
  //  3. Seal the class = extends class in this file, prevents in other files
  //  using keyword "sealed"
}
