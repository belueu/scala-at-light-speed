package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  /**
   * lazy evaluation
   * lazy evaluation is useful in infinite collections
   */
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1

  /**
   * "pseudo-collections": Option, Try
   */
  def methodWhichCanReturnNull(): String = "Hello, Scala"

  val anOption = Option(methodWhichCanReturnNull()) // Some("Hello, Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }
  // operations on Option: map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException
  //  try {
  //    methodWhichCanThrowException()
  //  } catch {
  //    case e: Exception => "Defend against evil exception"
  //  }

  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(exception) => s"I have obtained an exception: $exception"
  }
  // operations on Try: map, flatMap, filter

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */
  val aFuture = Future({
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  })
  Thread.sleep(2000)
  // future is a "collection" which contains a value when it's evaluated
  // future is composable whit map, flatMap and filter
  // monads

  /**
   * Implicits basics
   */
  // #1: implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt: Int = 46
  implicit val mySecondImplicitVal: Int = 51
  println(aMethodWithImplicitArgs(mySecondImplicitVal))

  // #2: implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven: Boolean = n % 2 == 0
  }

  println(23.isEven) // new MyRichInteger(23).isEven()
  // CAUTION !!! - use implicit whit care
}
