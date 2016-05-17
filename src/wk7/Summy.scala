package wk7

/**
  * Created by philhannant on 17/05/2016.
  */
object Summy extends App {

  trait Sum[A, B]
  case class Left[A, B](value: A) extends Sum[A, B]
  case class Right[A, B](value: B) extends Sum[A, B]

  println(Left[Int, String](1).value)
  println(Right[Int, String]("DFEEF").value)

  val sum: Sum[Int, String] = Right("foo")
  println(sum)

  sum match {
    case Left(x) => x.toString
    case Right(x) => x
  }

  println(sum)
}
