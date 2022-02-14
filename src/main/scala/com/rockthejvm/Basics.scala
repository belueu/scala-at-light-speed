package com.rockthejvm

object Basics extends App {
  // defining the first value

  val meaningOfLife: Int = 42 // const int meaningOfLife = 42; - This java way

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false // type inference

  // strings and strings operations
  val aString = "I love Scala"
  val aComposedString = "I" + " love" + " scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // Define expressions
  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999

  val chainedIfExpressions =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  // code blocks
  val aCodeBlock = {
    val aLocalValue = 67

    // the last expression of the code is the value of the code block
    aLocalValue + 3
  }

  // define a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n-1)

  /*
    factorial(5) = 5 * factorial(4) = 5 * 24 = 120
    factorial(4) = 4 * factorial(3) = 4 * 6
    factorial(3) = 3 * factorial(2) = 3 * 2
    factorial(2) = 2 * factorial(1) = 2 * 1
    factorial(1) = 1
  */

  // In Scala we don't use loops or iterations, we use RECURSION!

  // the Unit return types = no meaningful value, resembles the "void" in java
  //  type of SIDE EFFECTS
  println("I like scala") // System.out.println, printf, print console.log

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit")
  }

  val theUnit = ()
}
