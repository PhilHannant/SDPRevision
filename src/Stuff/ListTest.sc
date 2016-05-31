def f(xs: List[Int], g: (Int, Int) => Boolean) = {
  def h(x: Int, xs: List[Int]): List[Int] =
    xs match {
      case List() => List(x)
      case y :: ys => if (!g(x,y)) x :: xs else y :: h(x, ys)
    }
  (xs :\ List[Int]())(h)
}

f(List(3, 6, 1, 3, 8, 7, 9, 1), (_ > _))


sealed trait TrafficLight
final case object Red extends TrafficLight
final case object Yellow extends TrafficLight
final case object Green extends TrafficLight

sealed trait Calculation
final case class Success(x: Int) extends Calculation
final case class Failure(str: String) extends Calculation

trait PimpedList[T] {
  val list: List[T]

  def length: Int = {
    def iter(acc: Int, list: List[T]): Int = {
      list match {
        case Nil => 0
        case head :: tail => iter(acc + 1, tail)
      }
    }
    iter(0, list)
  }
}
val testList = List(3, 6, 1, 3, 8, 7, 9, 1)
testList.length
