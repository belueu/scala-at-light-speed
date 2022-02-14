package com.rockthejvm

object ObjectOrientation extends App {
  class Animal {
    val age = 0

    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal // constructor definition

  val aDog = new Dog("Lassie")

  // constructor arguments are NOT fields: need to put val before the constructor argument
  val dogName = aDog.name
  println(dogName)

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hitachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val haLegs = true // by default public, can be restricted by using private or protected

    def walk(): Unit
  }

  // interface = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Plant {
    def grow(): Unit = println("I'm growing")
  }

  val aPlant = new Plant

  trait Omnivore {
    def eat(animal: Animal, plant: Plant): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // '?!' valid method name
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Omnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I eat meat only")

    override def eat(animal: Animal, plant: Plant): Unit = println("I eat people and i like grass too..")

    override def eat(): Unit = super.eat()

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCrocodile = new Crocodile
  aCrocodile.eat(aDog)
  aCrocodile eat aDog // infix notation = object method argument, only available for method with ONE argument
  aCrocodile.eat(anAnimal)
  aCrocodile.eat(anAnimal, aPlant)
  aCrocodile.eat()
  aCrocodile ?! "What if we could fly"

  // operators in Scala are methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  println(basicMath)
  println(anotherBasicMath)

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm a dinosaur, i can eat anything")
  }

  /*
    What you tell the compiler:

    class Carnivore_Anonymous_32756 extends Carnivore {
      override def eat(animal: Animal): Unit = println("I'm a dinosaur, i can eat anything")
     }

     val dinosaur = new Carnivore_Anonymous_32756
   */

  // singleton object
  object MySingleton {
    val mySpecialValue = 3.141

    def mySpecialMethod(): Double = 1.61612

    def apply(x: Double): Double = x + 1
  } // is the only instance of the MySingleton type

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to the above

  object Animal { // companions - companion object
    // companions can access each other's  private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
  case classes = lightweight data structure s wit some boilerplate
  - sensible equals and hash code
  - serialization
  - companion with apply
  - pattern matching
  */

  case class Person(name: String, age: Int)

  // may be constructed without 'new'-keyword
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T] {
    def heat: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head // string
  val lastString = aStringList.tail // list of type string

  // Point #1: in Scala we usually operate with Immutable values/objects
  // Any modification to an object must return ANOTHER object
  /*
    Benefits:
    1) works miracles in multithreaded/ distributed env
    2) helps making sens of the code ("reasoning about")
   */
  val reversedList = aList.reverse // returns a NEW list

  // Point #2: Scala is closest to the OOP ideal
}
