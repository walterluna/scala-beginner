package Lectures.Pt4PM

import Lectures.Pt1Basics.Expressions

import scala.util.Random

object PatternMatching extends App {

  val r = new Random()
  val x = r.nextInt(10)

  //  switch on steroid
  val description = x match {
    case 1 => "The one"
    case 2 => "Double or nothing"
    case 3 => "Third time is the charm"
    case _ => "Something else" // _ = WILDCARD or Default
  }

  println(x)
  println(description)

  //  1. Decompose values
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)

  //    {} are optional
  val greeting = bob match
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US "
    case Person(n, a) => s"Hi, my name is $n and I'm $a years old"
    case _ => "I don't know who I am"

  println(greeting)

  /* Exercise
  1. Write a function that uses PM
    takes an Expr => human readable from

  Sum(Number(2), Number(3)) => 2+3
  
  */

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  val e1 = Sum(Number(1), Number(2))

  def toHumanReadable(expr: Expr): String = {
    expr match
      case Number(n) => s"$n"
      case Sum(e1, e2) => s"${toHumanReadable(e1)} + ${toHumanReadable(e2)}"
      case Prod(e1, e2) => {
        def withParentheses(e: Expr) = {
          e match
            case Prod(_, _) => toHumanReadable(e)
            case Number(_) => toHumanReadable(e)
            case _ => s"(${toHumanReadable(e)})"
        }

        withParentheses(e1) + " * " + withParentheses(e2)
      }
  }

  println(toHumanReadable(Sum(Number(1), Number(2))))
  println(toHumanReadable(Sum(Sum(Number(1), Number(2)), Number(3))))
  println(toHumanReadable(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(toHumanReadable(Sum(Prod(Number(2), Number(1)), Number(3))))
}
