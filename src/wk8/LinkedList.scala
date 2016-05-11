package wk8

import atomic.AtomicTest._

import scala.collection.immutable.Stream.Empty
/**
  * Created by philhannant on 10/05/2016.
  */

sealed trait Result[A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

sealed trait LinkedList[T] {
  def length: Int =
    this match {
      case Pair(hd, tl) => tl.length + 1
      case End() => 0
    }

  def contains(x: T): Boolean =
    this match {
      case Pair(hd, tl) =>
        if (hd == x)
          true
        else
          tl.contains(x)
      case End() => false
    }

  def apply(x: Int): Result[T] =
    this match {
      case Pair(hd, tl) =>
        if (x == 0)
          Success(hd)
        else
          tl(x-1)
      case End() => Failure("Index out of bounds")
    }
}
final case class Pair[T](head: T, tail: LinkedList[T]) extends LinkedList[T]

final case class End[T]() extends LinkedList[T]




object testArea extends App {

//  val example = Pair(1, Pair(2, Pair(3, End())))
//  assert(example.length == 3)
//  assert(example.tail.length == 2)
//  assert(End().length == 0)

//  val example = Pair(1, Pair(2, Pair(3, End())))
//  assert(example.contains(3) == true)
//  assert(example.contains(4) == false)
//  assert(End().contains(0) == false)
  // This should not compile
  // example.contains("not an Int")

    val example = Pair(1, Pair(2, Pair(3, End())))
//  assert(example(0) == 1)
//  assert(example(1) == 2)
//  assert(example(2) == 3)
//  assert(try {
//    example(3)
//    false
//  } catch {
//    case e: Exception => true
//  })

  assert(example(0) == Success(1))
  assert(example(1) == Success(2))
  assert(example(2) == Success(3))
  assert(example(3) == Failure("Index out of bounds"))
}