42
true
123L
42.0
'a'
"a"
"Hello World"
println("Hello World")

//'Hello world' //doesn't like it, makes a symbol if just 'hello
val a = 1
val b = 2
if (a > b) "alien" else "predator"


if (a > b) "alien" else 2001

if(true) "hello"

1 + 2 + 3
6
object calc {

  def square(x: Double) = {
    val res = x * x
    res
  }

  def cube(x: Double) = {
    val res = x * x * x
    res
  }
}

val y = calc.square(10)
val z = calc.cube(102)

import Numeric.Implicits._

object calc2{

  def square[T: Numeric] (x: T) = {
    val res = x * x
    res
  }

  def cube[T: Numeric] (x: T) = {
    val res = x * x * x
    res
  }
}

object argh {
  def a = {
    println("a")
    1
  }
  val b = {
    println("b")
    a + 2
  }
  def c = {
    println("c")
    a
    b + "c"
  }
}
argh.c + argh.b + argh.a

case class Person(firstName: String, lastName: String) {
}

//object Alien{
//
//  def greet(per: Person): String = {
//    "Hello " + per.firstName
//  }
//
//}
//
//val newPer = new Person("mike", "adams")
//Alien.greet(newPer)

import pacakagey.classy1
val classy1Class = new classy1

import pacakagey.classy2
val classy2Class = new classy2

import pacakagey.classy3
val classy3Class = new classy3

val list = List(1,2,3,4,5)
list.head
list.sum
list.max
list.min
list.tail
list.reverse

val set = Set(1,2,3,4,5,65,4)
set.head
set.sum
set.subsets()

val langauge = Set("English", "French", "Spanish", "German", "Chinese")
language.+("Turkish")

sealed trait IntList {

  def fold[T](end: T, f: (Int, T) => T): T =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
  def length: Int =
    fold(0, (_, tl) => 1 + tl)


  def product: Int =
    fold(0, (hd, tl) => hd * tl)

  def sum: Int =
    fold(0, (hd, tl) => hd + tl)

  def double: IntList =
    fold[IntList](End, (hd, tl) => Pair(hd * 2, tl.double))


final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

