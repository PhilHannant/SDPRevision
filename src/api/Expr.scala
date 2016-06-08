package api

abstract class Expr

case class Number(num: Double) extends Expr
case class Var(name: String) extends Expr
case class Plus(left: Expr, right: Expr) extends Expr
case class Fun(param: String, body: Expr) extends Expr
case class App(fun: Expr, arg: Expr) extends Expr
case class Let(name: String, expr: Expr, body: Expr) extends Expr

abstract class Value
case class NumValue(num: Double) extends Value
case class ClosureValue(param: String, body: Expr, env: Evaluation.Env)
  extends Value


object Operations {
  def reduce(expr: Expr) =
    expr match {
      case Plus(Number(i), Number(j)) => Number(i + j) //if plus has 2 numbers in it then the sum is returned wrapped in Number
      case Plus(Number(0), e) => e //if plus has a number with zero then it returns e
      case App(Fun(param, body), e) => Let(param, e, body) //if app(fun then let returned
      case Let(x, e, Var(y)) if x == y => e //if x = y in let func then e is returned
      case _ => expr
    }
  def simplify(expr: Expr): Expr =
    expr match {
      case Number(d) => Number(d) //whereever a number on its own it is returned
      case Var(name) => Var(name) //same for var
      case Plus(left, right) => reduce(Plus(simplify(left), simplify(right))) //plus with 2 values is reduced with each value being simplified first
      case Let(name, expr, body) => Let(name, simplify(expr), simplify(body)) //same for any lets parsed in
      case Fun(param, body) => Fun(param, simplify(body))
      case App(fun, arg) => reduce(App(simplify(fun), simplify(arg)))
    }
}


object Evaluation {
  type Env = Map[String, Value]
  def mtEnv(): Env = Map()
  val num: Value => Double = {

    case NumValue(num) => num
  }
  def plus(x: Value, y: Value) = NumValue(num(x) + num(y))
  def eval(expr: Expr): Value = eval(expr, mtEnv())
  def eval(expr: Expr, env: Env): Value = {println("expr " + expr + " env " + env);
    expr match {
      case Number(d) => NumValue(d)
      case Var(name) => /*println("name " + name)*/; env(name)
      case Plus(left, right) => /*println("env" + env)*/; plus(eval(left, env), eval(right, env))
      case Let(name, expr, body) => /*println("name " + name + " expr " + expr + " body " + body)*/;{
        eval(body, env + (name -> eval(expr, env)))
      }
      case Fun(param, body) => ClosureValue(param, body, env)
      case App(fun, arg) => {
        val ClosureValue(param, body, env2) = eval(fun, env)
        val v = eval(arg, env)
        println("env1 " + env)
        println("arg1 " + arg)
        println("param " + param)
        println("body " + body)
        println("env2 " + env2)
        eval(body, env2 + (param -> v))
      }
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Evaluation.eval {
      Let("y", Number(3),
        Let("f", Fun("x", Plus(Var("x"), Var("y"))),
          Var("f")))
    })

    println(Evaluation.eval {
      Operations.simplify {
        App(Fun("y", Plus(Number(1), Var("y"))), Plus(Number(2), Number(3)))
      }
    })

    println(Operations.reduce {
      Operations.simplify {
        Let("y", Number(3),
          Let("f", Fun("x", Plus(Var("x"), Plus(Var("y"), Number(12)))), Var("f")))
      }
    })

    println(Evaluation.eval {
      Let("x", Number(11),
        Let("f", Fun("y", Plus(Var("x"), Var("y"))),
          Let("x", Number(20),
            App(Var("f"), Number(12)))))
    })

    println(App(Var("f"), Number(12)))

    println(Let("x", Number(20), App(Var("f"), Number(12))))

    println("1 " + Let("f", Fun("y", Plus(Var("x"), Var("y"))),
    Let("x", Number(20),
    App(Var("f"), Number(12)))))

    println("1" + Operations.reduce(App(Fun("addition", Plus(Number(2.0), Number(5.0))), Number(10.00))))
    println(Operations.reduce(Var("Olya")))
    println(Operations.reduce(Let("Olya",Number(8), Var("Olya"))))
    println(Operations.simplify(Plus(Number(2.0), Number(5.0))))
    println(Operations.simplify(Plus(Number(0), Var("Olya"))))
    println(Operations.reduce(Var("Olya")))
    println(Operations.reduce(Let("y", Number(3), Var("y"))))
    println(Operations.simplify(Plus(Number(2.0), Number(5.0))))
    println(Evaluation.eval(Number(2.0)))
  }
}







//
// Evaluation.eval {
//      Let("x", Number(11),
//        Let("f", Fun("y", Plus(Var("x"), Var("y"))),
//          Let("x", Number(20),
//            App(Var("f"), Number(12)))))
