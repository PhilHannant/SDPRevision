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


class Language {
  override def toString = "Language"
}
trait ObjectOriented extends Language {
  override def toString = "Object-Oriented -> " + super.toString
}
trait Functional extends Language {
  override def toString = "Functional -> " + super.toString
}
trait HigherOrderFunctions extends Functional {
  override def toString = "HO-Functions -> " + super.toString
}
trait Traits extends ObjectOriented {
  override def toString = "Traits -> " + super.toString
}
class Scala extends Language with Traits with HigherOrderFunctions {
  override def toString = "Scala -> " + super.toString
}
val language = new Scala

List(List("a"), List("ab"), List("abc"), List("abcd"))
.map(x => x.count(s => s.length > 1))

List(List(1), List(1, 1), List(1, 1, 1), List(1, 1, 1, 1))
.filter(x => x.length > 1)
  .map(x => x.reduceRight((a,b) => a * b))