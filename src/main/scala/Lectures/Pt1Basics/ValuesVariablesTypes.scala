package Lectures.Pt1Basics

object ValuesVariablesTypes extends App {
  //  VALUES
  //  Declare a value (immutable)
  //  Types for val are optional (inferred from usage)
  val x: Int = 42;
  println(x);
  //  x=2  NOT ALLOWED

  //  Semi-colons are optional
  val someString: String = "Hello";

  val aBoolean: Boolean = true;
  val aChar: Char = 'a';
  val anInt: Int = x;
  val aShort: Short = 4613
  val aLong: Long = 3942839044543423L;
  val aFloat: Float = 3.89F;
  val aDouble: Double = 3.141516;

  //  VARIABLES
  //  They are mutable, they can change
  var aVariable: Int = 4;
  aVariable = 5 //side effects


}
