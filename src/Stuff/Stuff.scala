package Stuff

/**
  * Created by philhannant on 11/05/2016.
  */
object stuffTest extends App {


  def map(list:List[Int], f:(Int) => Int):List[Int] = {
    list match {
      case Nil => Nil
      case head::tail => f(head)::map(tail, f)
    }
  }

  def foldRight(list:List[Double], initVal:Double, f:(Double, Double) => Double):Double = {
    list match {
      case Nil => initVal
      case head::tail => f(head, foldRight(tail, initVal, f))
    }
  }

  def foldLeft(list:List[Double], initVal:Double, f:(Double, Double) => Double):Double = {
    list match {
      case Nil => initVal
      case head :: tail => foldLeft(tail, f(initVal, head), f)
    }
  }
    def flatten(lst: List[_]): List[Any] = lst match {
      case Nil => Nil
      case (head: List[_]) :: tail => flatten(head) ::: flatten(tail)
      case head :: tail => head :: flatten(tail)
    }


  val list = List(1.0,2.0,3.0,4.0,5.0)
//  val newList = map(list, x=>x*x)
  val newList2 = foldLeft(list, 1, (a:Double,i:Double) => (a/i))
//  println(newList)
  println(newList2)
}
