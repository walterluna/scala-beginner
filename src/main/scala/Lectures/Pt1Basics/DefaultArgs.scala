package Lectures.Pt1Basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) 1
    else trFact(n - 1, acc * n)
  }

  trFact(10)
  trFact(10, 2)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println("Saving your picture")

  /*
    1. Pass every argument
    2. Name the arguments
   */

  savePicture("jpg", 800, 600)
  savePicture(height = 600, width = 800)
}

