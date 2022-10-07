package Lectures.Pt3FP

import scala.util.Random

object Options extends App {


  //
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  //  they were created to use unsafe APIs
  def unsafeMethod(): String = null

  //  val result = Some(unsafeMethod()) //WRONG
  val result = Option(unsafeMethod()) //Some or none
  println(result)

  //  chained methods
  def backupMethod(): String = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)

  //  If you design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Option("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainedResult)

  //  function on Options
  println(myFirstOption.isEmpty)
  //  println(myFirstOption.get) //UNSAFE

  //  map, flatmap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter((_ > 10)))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  //  for-comprehensions

  /*
    Exercise.
   */
  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  //  try to establish a connection, if so - call the connect method
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  //  with chained calls
  config.get("host")
    .flatMap(h => config.get("port").flatMap(p => Connection(h, p)))
    .map(con => con.connect)
    .foreach(println)

  //  using for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  println(forConnectionStatus)
}
