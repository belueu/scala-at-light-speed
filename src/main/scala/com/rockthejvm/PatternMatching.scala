package com.rockthejvm

object PatternMatching extends App {
  // switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  // PM is an EXPRESSION
  println(order)

  // Case class decomposition
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi my name is $n and I am $a years old."
    case _ => "Something else"
  }
  println(personGreeting)

  // deconstructing tuples
  val aTuple = ("Michale", "Jackson", "Pop")
  val description = aTuple match {
    case (artistFirstName, artistLastname, genre) => s"The artist is $artistFirstName $artistLastname and he writes and sings $genre songs."
    case _ => "This is not a tuple that i can deconstruct"
  }
  println(description)

  // decomposing lists
  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "This list is strange" // if PM doesn't match anything it will throw a MatchError
  }

  // IMPORTANT! - PM will try all cases in sequence (cases from top to bottom)
}