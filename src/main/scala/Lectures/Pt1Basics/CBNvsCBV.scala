package Lectures.Pt1Basics

object CBNvsCBV extends App {

  //  Calculates the value of the passed expression for x and uses that value inside the function
  def calledByValue(x: Long): Unit = {
    println("by value: ", x)
    println("by value: ", x)
  }

  //  takes the expression as the param and evaluates the expression everytime it's used in the code
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int): Unit = println(x)

  //  printFirst(infinte(), 2)
  printFirst(2, infinite())
}
