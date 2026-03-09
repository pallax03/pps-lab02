package tasks

val absolute: (x: Int) => Boolean = _ >= 0
val absoluteString: (x: Int) => String = absolute(_) match
  case true => "positive"
  case false => "negative"

def absoluteMethod(x:Int): String = x>=0 match
  case true => "positive"
  case false => "negative"

@main
def mainPositive():Unit =
  println(absoluteString(10))
  println(absoluteString(0))
  println(absoluteString(-10))

  println(absoluteMethod(10))
  println(absoluteMethod(0))
  println(absoluteMethod(-10))

val empty: String => Boolean = _ == ""
//val neg: (String => Boolean) => (String => Boolean) = (p: String => Boolean) => (s: String) => !p(s)
val neg: (String => Boolean) => (String => Boolean) = p => !p(_)

@main
def mainString(): Unit =
  val notEmpty = neg(empty)
  println(notEmpty("foo")) // true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty("")) // true


val p1: Double => Double => Double => Boolean = (x: Double) => (y:Double) => (z:Double) => x <= y && y == z
val p2: (Double, Double, Double) => Boolean = (x: Double, y:Double, z:Double) => x <= y && y == z
def p3(x: Double)(y: Double)(z: Double): Boolean = x <= y && y == z
def p4(x: Double, y: Double, z: Double): Boolean = x <= y && y == z

@main
def mainTask2Currying(): Unit =
  println(p1(1)(5)(5))
  println(p2(1, 5, 5) == p1(1)(5)(5))
  println(p4(1, 5, 5) == p3(1)(5)(5))



def compose(f: Int => Int, g: Int => Int): Int => Int = (x:Int) => f(g(x))
val composeLambda: (Int => Int, Int => Int) => Int => Int = (f: Int => Int, g: Int => Int) => (x: Int) => f(g(x))

@main
def mainTask2Compositions(): Unit =
  println(compose(_ - 1, _ * 2)(5) == 9)
  println(composeLambda(_ - 1, _ * 2)(5) == 9)