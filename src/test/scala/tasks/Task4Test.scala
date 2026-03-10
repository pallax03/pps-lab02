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
    val literal: Expr = Literal(number)
    assertEquals(number, evaluate(literal))
    assertEquals(s"$number", show(literal))

  @Test
  def testAdd(): Unit =
    val add: Expr = Add(x, y)
    assertEquals(evaluate(x)+evaluate(y), Expr.evaluate(add))
    assertEquals(s"(${evaluate(x)} + ${evaluate(y)})", show(add))

  @Test
  def testMultiply(): Unit =
    val multiply: Expr = Multiply(x, y)
    assertEquals(evaluate(x)*evaluate(y), evaluate(multiply))
    assertEquals(s"(${evaluate(x)} * ${evaluate(y)})", show(multiply))

  @Test
  def testRecursiveExpr(): Unit =
    val add: Expr = Add(x, y)
    val multiply: Expr = Multiply(add, z)
    val result: Expr = Add(add, multiply)
    val expectedAdd: Int = evaluate(x)+evaluate(y)
    val expectedResult: Int = expectedAdd + (expectedAdd * evaluate(z))
    assertEquals(expectedResult, evaluate(result))
    val expectedAddShow: String = show(add)
    val expectedResultShow: String = s"($expectedAddShow + ($expectedAddShow * ${show(z)}))"
    assertEquals(expectedResultShow, show(result))