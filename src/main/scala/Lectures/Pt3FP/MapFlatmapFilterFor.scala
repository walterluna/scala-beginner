package Lectures.Pt3FP

object MapFlatmapFilterFor extends App {
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  //  map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  //  filter
  println(list.filter(_ % 2 == 0))

  //  flatmap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  //  EX: print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  //This is how we "iterate"
  val combinations = chars.flatMap(c => numbers.flatMap(n => colors.map(color => c + n.toString + "-" + color)))
  println(combinations)

  //  foreach
  list.foreach(println)

  //  for comprehensions
  val forCombinations = for {
    //  to filter, we use guards, this translates to a filter by the compiler
    n <- numbers if (n % 2 == 0)
    c <- chars
    color <- colors
  } yield c + n.toString + "-" + color
  println(forCombinations)

  //  This is compiled to a foreach call, we can use this syntax for side effects
  for {
    n <- numbers
  } println(n)

  //  syntax overload
  list.map { x =>
    x * 2
  }

  /*
    1. Check, Does MyList support comprehensions?
      - We need the following signatures
      - map(f: A => B) => MyList[B]
      - filter(p: A => Boolean) => MyList[A]
      - flatMap(f: A => MyList[B]) => MyList[B]
    2. Implement a small collection of at most one element called Maybe[+T]
  */


}
