package tasks

import org.junit.Test
import org.junit.Assert.*
import Expr.*
class Task4Test:

  val x: Expr = Literal(5)
  val y: Expr = Literal(10)
  val z: Expr = Literal(2)

  @Test
  def testLiteral(): Unit =
    val number: Int = 5
    assertEquals(number, evaluate(Literal(number)))

  @Test
  def testAdd(): Unit =
    val add: Expr = Add(x, y)
    assertEquals(evaluate(x)+evaluate(y), Expr.evaluate(add))

  @Test
  def testMultiply(): Unit =
    val multiply: Expr = Multiply(x, y)
    assertEquals(evaluate(x)*evaluate(y), evaluate(multiply))