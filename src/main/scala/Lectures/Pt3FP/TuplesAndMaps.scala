package Lectures.Pt3FP

import scala.annotation.tailrec

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

  /*
    1. What would happen if I have duplicate keys from using map on a Map
        !!! They overwrite, be careful with mapping keys
    2. Overly simplified social network based on maps
      Person = String
      - add a person to the network
      - remove
      - friend (mutual)
      - unfriend (mutual)

      - number of friends of a person
      - person with most friends
      - how many people with no friends
      - is there a connection between two people?
  */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] =
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] =
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)

  // Jim,Bob,Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))
}
