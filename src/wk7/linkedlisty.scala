package wk7

/**
  * Created by philhannant on 17/05/2016.
  */
object linkedlisty extends App{


  sealed trait LinkedList[A]{
    def head: A
    def tail: LinkedList[A]
    def length(h: A, l: LinkedList[A]): Int
    def apply(n: Int): A
    def contains(item: A): Boolean
  }
  case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A] {

    def length(h: A, l: LinkedList[A]): Int = l match {
      case e: Empty[A] => 1
      case t: LinkedList[A] => 1 + length(t.head, t.tail)
    }

    def apply(n: Int): A = this match {
      case Pair(head, tail) =>
        if (n == 0)
          head
        else
          tail(n-1)
      case _ => throw new Exception("Bad things happened")
      }


    def contains(item: A) = this match{
      case Pair(head, tail) =>
        if(item == head) true
        else tail.contains(item)
      case _ => false
    }

  }


  case class Empty[A]() extends LinkedList[A]{
    def head = throw new Exception("error")
    def tail = throw new Exception("error")

    def length(h: A, l: LinkedList[A]) = 0

    def apply(n: Int) = throw new Exception("Bad things happened")

    def contains(item: A) = false
  }

  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Empty())))
  list.isInstanceOf[LinkedList[Int]]

  println(list.head) // returns 1 as an Int
  println(list.tail.head) // returns 2 as an Int
  println(list.tail.tail) // returns Pair(3, Empty()) as a LinkedList[Int]
  println(list.length(list.head, list.tail))
  println(list(0))
  println(list.contains(2))
  println(list.contains(4))

  case class PairNew[A, B](one: A, two: B)
  val pair = PairNew[String, Int]("hi", 2)
  println(pair.one)
}
