package Lectures.Pt4PM

object BracelessSyntax extends App {

  //  if - expression
  val anIfExpression = if (2 > 3) "bigger" else "smaller"

  //  java-style
  val anIfExpression2 =
    if (2 > 3) {
      "bigger"
    } else {
      "smaller"
    }

  //    compact
  val anIfExpression3 =
    if (2 > 3) "bigger"
    else "smaller"

  //  scala 3
  //  can also be written as a one liner
  val anIfExpression4 =
  if 2 > 3 then
    "bigger" //higher indentation than if (significant indentation)
  else
    "smaller"

  //  for comprehensions
  val aForComprehension = for {
    n <- List(1, 2, 3)
    s <- List("Black", "White")
  } yield s"$n$s"

  //  scala 3 brace less
  val aForComprehension2 = for
    n <- List(1, 2, 3)
    s <- List("Black", "White")
  yield s"$n$s"

  //  Pattern matching can also be written using brace-less syntax

  //  methods can be defined brace-less
  def computeMeaningOfLife(arg: Int): Int =
    val partialResult = 40

    partialResult + 2

  //  classes use : operator to open indentation region
  //  same for traits, objects, enums
  class Animal:
    def eat(): Unit =
      println("I'm eating")
    end eat

    def grow: Unit =
      println("I'm growing")
  end Animal
  //  End token
  //  For big files, it's recommended
  //  Can be used for if, match, for, methods, classes, traits, objects, enums

  //  anonymous classes
  val aSpecialAnimal = new Animal :
    override def eat(): Unit = println("I'm special")

  //  What does significant indentation mean?
  //  Strictly larger indentation
  //  3 spaces +2 tabs > 2 spaces +2 tabs
  //


  println(computeMeaningOfLife(3))
}
