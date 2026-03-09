package it.unibo.pps.u02

object Currying extends App :

  // standard function with no currying
  def mult(x: Double, y: Double): Double = x * y

  // function with currying
  // curriedMult has actually type: Double => (Double => Double)
  def curriedMult(x: Double)(y: Double): Double = x * y

  def divide(x: Double, y: Double): Double = x / y
  val divideLambda: (x: Double, y: Double) => Double = _ / _

  def curriedDivide(x: Double)(y: Double): Double = divide(x, y)
  val curriedDivideLambda: Double => Double => Double = x => curriedDivide(x)
  val curriedDivideLambdaInv: Double => Double => Double = x => y => curriedDivide(y)(x)
  val divideBy4 = curriedDivideLambdaInv(4)

@main
def mainWarmUp(): Unit =
  import Currying.*
  // slightly different syntax at the call side..
  println(mult(10, 2)) // 20
  println(curriedMult(10)(2)) // 20

  // curriedMult can be partially applied!
  val twice: Double => Double = curriedMult(2)

  println(twice(10)) // 20

  // => is right-associative, hence it is equal to:
  //val curr...: Double => (Double => Double) = x => (y => x*y)
  val curriedMultAsFunction: Double => Double => Double = x => y => x * y

  println(curriedMultAsFunction(10)(2)) // 20
  println(curriedMultAsFunction) // u02.Currying$$$Lambda$7/...
  println(curriedMultAsFunction(10)) // u02.Currying$$$Lambda$12/...

//x <= y = z
// val usingFunctions: ((Double, Double) => Double) => ((Double, Double) => Boolean) =
//  (f: (Double, Double) => Double) => (x: Double, y:Double) => x <= y && y == f(x, y)