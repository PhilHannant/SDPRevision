object divide {

  def apply(x: Int, y: Int): DivisionResult = y match {
    case 0 => new Infinite
    case y if y > 0 => new Finite(x/y)
  }


}

sealed trait DivisionResult

case class Finite(x: Int) extends DivisionResult
case class Infinite() extends DivisionResult

divide(1, 0)
divide(1, 2)

def divideF(x: Int, y: Int) = {
  val res = divide(x, y)
  res match {
    case Finite(z) => "You can divide this"
    case Infinite() => "No! You can't divide by zero..."
  }
}

divideF(1, 0)
divideF(1, 2)

trait publication
class book(author: String) extends publication
class periodical(editor: String, volume: Int, issue: Int) extends publication
class manuscript


