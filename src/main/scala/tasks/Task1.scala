package tasks

object Currying:
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
  println(divide(10, 2))
  println(curriedDivide(10)(2))

  val divideBy2: Double => Double = curriedDivideLambdaInv(2)

  println(divideBy2(20)) // 10

//x <= y = z
// val usingFunctions: ((Double, Double) => Double) => ((Double, Double) => Boolean) =
//  (f: (Double, Double) => Double) => (x: Double, y:Double) => x <= y && y == f(x, y)