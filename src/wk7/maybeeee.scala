package wk7

/**
  * Created by philhannant on 17/05/2016.
  */
object maybeeee extends App {

  sealed trait Maybe[A]

  case class Full[A](x: Int) extends Maybe[A]

  case class Empty[A]() extends Maybe[A]

  object divide {
    def apply(x: Int, y: Int): Maybe[Int] = y match {
      case 0 => new Empty
      case y if y > 0 => new Full(x / y)
    }
  }


 println(divide(1, 0))
 println(divide(1, 2))


  divide(1, 0) match {
    case Full(value) => println(s"It's finite: $value")
    case Empty() => println(s"It's infinite")
  }

  divide(5, 1) match {
    case Full(value) => println(s"It's finite: $value")
    case Empty() => println(s"It's infinite")
  }
}


