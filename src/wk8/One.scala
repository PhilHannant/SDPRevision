package wk8

object One {

  def sqrtIter(guess: Double, x: Double): Double =

    if (isGoodEnough(guess, x)) guess

    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs(square(guess) - x) < 0.001

  def sqrt(x: Double) = sqrtIter(1.0, x)

  def square(x: Double) = x * x

  def abs(x: Double) = if (x > 0) x else -x

}

object test extends App{

  val test = One

  println(One.sqrtIter(2, 1))

  def factorial(n: Int): Int = {

    def facHelper(x: Int): Int =
      x match {
        case 0 => 1
        case _ => x * facHelper(x - 1)
      }
    println("Calling fibHelper")
    facHelper(n)
  }

  println(factorial(6))
}