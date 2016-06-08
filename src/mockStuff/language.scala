package mockStuff

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
class Scala extends Language with HigherOrderFunctions with Traits   {
  override def toString = "Scala -> " + super.toString
}
object lang extends App {
  val language = new Scala
  println(language)
}