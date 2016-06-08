package Stuff

/**
  * Created by philhannant on 11/05/2016.
  */
object stuffTest extends App {



  def map1[A, B](lst: List[A], f: A => B): List[B] =
    lst match {
      case Nil => Nil
      case head::tail => f(head) :: map1(tail, f)
    }


  def foldRight[A, B](list: List[A], init: B)(op: (A, B) => B): B = {
    def f(xs: List[A], acc: B): B = xs match {
      case Nil   => acc
      case x :: xs => println("x: " + x + " acc: " + acc);f(xs, op(x, acc))
    }
    f(list, init)
  }

  def foldLeft[A, B](list: List[A], init: B)(op: (B, A) => B): B = {
    def f(xs: List[A], acc: B): B = xs match {
      case Nil   => acc
      case x :: xs => println("x: " + x + " acc: " + acc);f(xs, op(acc, x))
    }
    f(list, init)
  }

  def filter[T](list: List[T], f: (T) => Boolean): List[T] =
    list match {
      case Nil => Nil
      case head :: tail => if (f(head)) head :: filter(tail, f) else filter(tail, f)
    }

//  def foldLeft(list:List[Double], initVal:Double, f:(Double, Double) => Double):Double = {
//    list match {
//      case Nil => initVal
//      case head :: tail => foldLeft(tail, f(initVal, head), f)
//    }
//  }
    def flatten(lst: List[_]): List[Any] = lst match {
      case Nil => Nil
      case (head: List[_]) :: tail => flatten(head) ::: flatten(tail)
      case head :: tail => head :: flatten(tail)
    }

  def zip[A, B](lst1: List[A], lst2: List[B]): List[(A, B)] =
    (lst1, lst2) match {
      case (Nil, _) => Nil
      case (_, Nil) => Nil
      case (x :: xs, y :: ys) => (x, y) :: zip(xs, ys)
    }

  def reduceLeft[A](list: List[A])(op: (A, A) => A): A = {
    val head = list.head
    def f(xs: List[A], acc: A): A = xs match {
      case Nil   => acc
      case x :: xs => println("x: " + x + " acc: " + acc);f(xs, op(acc, x))
    }
    f(list, head)
  }

  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = list match {
    case Nil => Nil
    case (x::xs) => f(x) ::: flatMap(xs)(f)
  }

  val list = List(10.0,2.0,3.0,4.0,5.0)
//  val newList = map(list, x=>x*x)
  val newList2 = foldLeft(list, 1.0)(_ / _)
//  println(newList)
  println(newList2)
  println(foldRight(list, 1.0)(_ / _))
  println(reduceLeft(list)(_ * _))



  val lst = List(List(1,2), List(3,4), List(5,3))
  val list2 = List(1,2,4,3,4,3,2,2)
  val lst2 = List("a","b","c","d","3")
  println(lst.zip(lst2))
  val input = (0 to 1000).map(_ => (0 to 1000).toList).toList
//  println(foldRight(list2, 1,  _))
  println("FL " + flatMap(lst)(x => x.map(_ * 2)))


  def j(xs: List[Int], g: (Int, Int) => Boolean) = {
    def h(x: Int, xs: List[Int]): List[Int] =
      xs match {
        case List() => List(x)
        case y :: ys => if (!g(x,y)) x :: xs else y :: h(x, ys)
      }
    (xs.:\(List[Int]())(h))
  }
  val v = j(List(3, 6, 1, 3, 8, 7, 9, 1), (_ > _))
  println(v)
}
