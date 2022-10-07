package Lectures.Pt3FP

object TuplesAndMaps extends App {

  //  tuples are finite ordered "lists"
  //  val aTuple = new Tuple2(2, " hello, Scala") // Tuple2[Int, String] = (Int, String)
  val aTuple = (2, " hello, Scala") // Tuple2[Int, String] = (Int, String)

  //  get position (not indexed from 0)
  println(aTuple._2)
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, scala", 2)

  //  Maps (key -> value) pairs
  val aMap: Map[String, Int] = Map()
  val phonebook = Map("Jim" -> 555, ("Daniel", 789)).withDefaultValue(-1)
  //  a -> b is sugar for  (a,b)
  println(phonebook)

  //  map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("Mary")) //throws NoSuchElementException if no default value

  //  add a paring
  val newParing = "Mary" -> 767
  val newPhoneBook = phonebook + newParing
  //  they are immutable, so we need to create a new one


  //  functions on maps

  //  map, flatmap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  //  filterKeys
  println(phonebook.view.filterKeys(_.startsWith("J")))

  //  mapValues
  println(phonebook.view.mapValues("342 - " + _).toMap)

  //  conversions to other collections
  println(phonebook.toList) //List of tuples

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(_.charAt(0)))

}
