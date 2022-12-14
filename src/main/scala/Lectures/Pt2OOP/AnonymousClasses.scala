package Lectures.Pt2OOP

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //  anonymous class
  val funnyAnimal = new Animal {
    override def eat: Unit = println("haha")
  }
  //  Looks like an instantiation of an abstract class
  //  But not really, it's an anonymous class

  //  compilers creates a new class in this case, with the name:
  //  Lectures.Pt2OOP.AnonymousClasses$$anon$1
  //  and creates an instance of the anonymous class

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi my name is ${this.name} ")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi, my name is Jim ,nice to meet you")
  }
  println(jim.getClass)

  //  Anonymous classes work for abstract an non abstract data types

  //  Pass required constructor arguments if any
  //  implement all abstract fields/methods
  //  work for traits and classes

  /*
    Exercises:
    1.  Generic trait MyPredicate[-T] with a little method test(T) => Boolean
    2.  Generic trait MyTransformer[-A, B] with a method transform(A) => B
    3.  MyList:
        - map(transformer) => MyList
        - filter(predicate) => MyList
        - flatMap(transformer from A to MyList[B]) => MyList[B]
        class EvenPredicate extends MyPredicate[Int]
        class StringToIntTransformer extends MyTransformer[String, Int]
        [1,2,3].map(n * 2) = [2,4,6]
        [1,2,3,4].filter(n % 2) = [2,4]
        [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
   */
}
