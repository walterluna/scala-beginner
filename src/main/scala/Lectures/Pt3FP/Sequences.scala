package Lectures.Pt3FP

import scala.util.Random

object Sequences extends App {

  //  Seq
  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence)
  println(aSequence.reverse)
  //  get index #2
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(Seq(7, 5, 6).sorted)

  //  ranges
  //  we can use 1 to 10 to include the upper limit
  //  we can use 1 until 10 to exclude the upper limit
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 until 10).foreach(x => println("Hello"))

  //  Lists
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList
  //  we can also prepend with +:
  //  and append with :+
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("-"))

  //  Arrays
  //  equivalent to java arrays
  val numbers = Array(1, 2, 3, 4)
  //  This creates an array of size 3
  val threeElements = Array.ofDim[Int](3)
  println(threeElements)
  //  the array is filled with default values or null if there are none
  threeElements.foreach(println)

  //  mutation
  numbers(2) = 0 //syntax sugar for numbers.update(2,0)
  println(numbers.mkString(" "))

  //  Arrays and seq
  val numbersSeq: Seq[Int] = numbers //implicit conversion
  println(numbersSeq)

  //  vectors
  //  default implementation for immutable seq
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  //  performance test
  //  vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  //  keeps reference to tail
  //  updating in the element takes long
  println(getWriteTime(numbersList))

  //  depth of the three is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))

}
