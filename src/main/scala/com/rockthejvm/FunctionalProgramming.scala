package com.rockthejvm

import scala.::

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function == bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ... Function22
   */

  val simpleIncrementor = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementor.apply(23) // 24
  simpleIncrementor(23) // similar to simpleIncrementor.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // functions wit 2 arguments and a String return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", "Scala") // "I love Scala"

  // syntax sugars
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  doubler(4) // 8

  val tripleValue: Int => Int = (arg: Int) => 3 * arg
  // or
  val fourTimesTheValue = (arg: Int) => 4 * arg
  val valueMultiplied = (value: Int, multiplier: Int) => value * multiplier

  /*
    new Function1[Int, Int] {
      override def apply(arg: Int): Int = 2 * arg
   */

  // Higher-order functions: take functions as arguments/return functions as results or both
  val aMappedList: List[Int] = List(1, 2, 3).map(listValue => listValue + 1) // map() is a Higher-order function
  println(aMappedList)

  val aFlatMappedList = List(1, 2, 3).flatMap(listValue => List(listValue, 2 * listValue))
  println(aFlatMappedList)

  val aFilteredList = List(1, 2, 3, 4, 5).filter(listValue => listValue <= 4)
  val aFilteredList2 = List(1, 2, 3, 4, 5).filter(_ <= 4) // this short syntax(_ <= 4) is equivalent to (x => x <= 4)
  println(aFilteredList)
  println(aFilteredList2)

  // all the pairs between the numbers 1,2,3 and the letters 'a', 'b', 'c'
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairs)

  // for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map/flatMap chain above

  /**
   * Collections
   */
  // list
  println("---List Examples---")
  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val remaining = aList.tail
  val aPrependedList = 0 :: aList // List(0, 1, 2, 3, 4, 5)
  val aPostpendedList = aList :+ 6 // List(1, 2, 3, 4, 5, 6)
  val anExtendedList = 0 +: aList :+ 6 // List(0, 1, 2, 3, 4, 5, 6)

  println(s"First list created: $aList")
  println(s"First element of the list, aka 'head': $firstElement")
  println(s"All elements from the list without 'head': $remaining")
  println(s"Added element '0' at the beginning of the list: $aPrependedList")
  println(s"Added element '6' at the end of the list: $aPostpendedList")
  println(s"Extended the list with elements '0' and '6' at beginning respectively end of the list: $anExtendedList")

  // sequences
  println("---Sequence examples---")
  val aSequence: Seq[Int] = Seq(1, 2, 3) // Seq.apply(1, 2, 3)
  val accessedElement = aSequence(1) // value at that index = 2
  println(s"Element from the sequence at index 1: $accessedElement")

  // vectors: fast Seq implementation
  // - vectors have the same methods as Seq
  println("---Vector examples---")
  val aVector = Vector(1, 2, 3, 4, 5)
  println(s" This is a vector: $aVector")

  // sets: collections with no duplicates
  println("---Set examples---")
  val aSet = Set(1, 2, 3, 4, 1, 2, 3) // result Set(1, 2, 3, 4)
  println(s"This is a set of unique elements: $aSet")
  val setHas5 = aSet.contains(5) // return a bool = false
  val anAddedSet = aSet + 5 // Set(1, 2, 3, 4, 5)
  println(s"Set with element '5' added: $anAddedSet")
  val aRemovedSet = aSet - 3 // Set(1, 2, 4, 5)
  println(s"Set with element '3' removed: $aRemovedSet")

  // ranges
  println("---Range examples---")
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList // duplicates all numbers from 1 to 1000
  println(s"Duplicates all numbers from 1 to 1000: $twoByTwo")
  val filteredEvens = aRange.filter(x => x % 2 == 0).toList // all even numbers from 1 to 1000
  println(s"All even numbers in the range of 1 to 1000: $filteredEvens")
  val filteredOdds = aRange.filter(x => x % 2 != 0).toList // all odd numbers from 1 to 1000
  println(s"All odd numbers in the range of 1 to 1000: $filteredOdds")

  // tuples: groups of values under the same value
  println("---Tuple examples---")
  val aTuple = ("Bon Jovi", "Rock", 1982)
  println(s"This is a tuple: $aTuple")
  // List of tuples
  val tupleList: List[(String, String, Int)] = List(("John", "Bohnjovi", 1982), ("Michael", "Jackson", 1963))
  println(s"This is a list of tuples: $tupleList")

  // maps: key -> value pairs
  println("---Map examples---")
  val aPhoneBook: Map[String, Int] = Map(
    ("Daniel", 123456789), // key: Daniel, value: 123456789
    ("Cristi", 234567891) // key: Cristi, value: 234567891
  )
  println(s"This is a map: $aPhoneBook")
}
