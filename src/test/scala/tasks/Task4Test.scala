package tasks

import org.junit.Test
import org.junit.Assert.*
import Expr.*
class Task4Test:

  @Test
  def testLiteral(): Unit =
    val constant: Int = 10
    val literal = Literal(constant)
    assertEquals(constant, Expr.evaluate(literal))

  @Test
  def testAdd(): Unit =
    val x: Expr = Literal(10)
    val y: Expr = Literal(5)
    val add: Expr = Add(x, y)
    assertEquals(10+5, Expr.evaluate(add))