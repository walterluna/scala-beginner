package Lectures.Pt3FP

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  //  Create success and failure explicitly
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Super failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU")

  //  Try Objects via apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  val anotherPotentialFailure = Try {
    //    code that might throw
  }

  //  Utilities
  println(potentialFailure.isSuccess)
  println(potentialFailure.isFailure)

  //  orElse
  def backupMethod: String = "A valid result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod))

  println(fallbackTry)

  //  IF you design an API and code might throw, use Try
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException("NO STRING FOR YOU"))

  def betteBackupMethod(): Try[String] = Success("A valid result")

  def betterFallback = betterUnsafeMethod() orElse (betteBackupMethod())

  println(betterFallback)

  //  map, flatmap, filter
  println(aSuccess.map((_ * 2)))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10)) //This can turn a success into a failure

  //  we can also use for-comprehensions

  /*
  Exercise
  */
  val hostname = "localhost"
  val port = "8080"

  def renderHtml(page: String) = println(page)

  class Connection {
    val r = new Random(System.nanoTime())

    def get(url: String): String = {
      if (r.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }
  }

  object HttpService {
    val r = new Random(System.nanoTime())

    def getConnection(h: String, p: String): Connection =
      if (r.nextBoolean()) new Connection
      else throw new RuntimeException("Port is busy")
  }

  //  if you get the html page from connection, print it to the console
  //  i.e. call renderHtml

  for {
    connection <- Try(HttpService.getConnection(hostname, port))
    page <- Try(connection.get("webPage.com"))
  } renderHtml(page)
}
