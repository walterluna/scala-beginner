package Lectures.Pt2OOP


import Playground.{PrinceCharming, Cinderella as Princess}
// name aliasing is supported

// we can import all definitions by using
// import Playground._


object PackagingAndImports extends App {
  //  A package, is a group of definitions under the same name
  //  99% of the time, this matched the directory structure
  //  package definitions are not expressions

  val writer = new Writer("Walter", "Luna", 1971)
  //  we can use definitions from inside the same package without the need to import them

  //  To use definitions from outside, we need to import packages
  val princess = new Princess

  //  Or, we  use the fully qualified name to avoid importing
  //  val otherPrincess = new Playground.Cinderella

  //  Packages are ordered in hierarchy
  //  They usually match directory structure

  //  package object
  //  Used as globals inside a package
  //  Can only be one per package (same name as the package)
  sayHello
  println(SPEED_OF_LIGHT)
  //  definitions inside of the package object, are accessible in all the package

  //  IMPORTS
  val prince = new PrinceCharming

  //  default imports
  // java.lang - String, Object, Exception
  // scala Int, Nothing, Function
  // scala.predef - println, ???
}
