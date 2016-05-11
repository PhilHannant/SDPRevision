package wk8

object One {

  def sqrtIter(guess: Double, x: Double): Double =

    if (isGoodEnough(guess, x)) guess

    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs(square(guess) - x)/x < 0.001

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

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def iter(a: Int, result: Int): Int = {
      if (a > b) result
      else iter(a + 1, result + f(a))
    }
    iter(a, 0)
  }

  def linearSum(a: Int, b: Int): Int =
    if (a > b) 0
    else a + linearSum(a + 1, b)

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    def iter(a: Int, result: Int): Int = {
      println(a)
      if (a > b) result
      else iter(a + 1, result * f(a))
    }
    iter(a, 1)
  }

  def factorial2(n: Int): Int =
    n match {
    case _ => product(Int=>Int)(n, 0)
  }

  def operate(f: Int => Int)
             (oper: (Int, Int) => Int)
             (a: Int, b: Int, init: Int): Int = {
    def iter(a: Int, result: Int): Int = {
      if (a > b) result
      else iter(a + 1, oper(result, f(a)))
    }
    iter(a, init)
  }

  println(linearSum(1,7))
  println(sum(Int => Int)(1, 7))

  println(product(Int=>Int)(1,3))

  println(factorial(5))

//  println(operate(Int=>Int)((a, b) => init)(1,7,0))
}