package tasks

def power(base: Double, exponent: Int): Double = exponent match
  case 0 => 1
  case _ => base * power(base, exponent-1)

def powerTail(base: Double, exponent: Int): Double =
  @annotation.tailrec
  def _power(base:Double, exponent: Double, acc: Double): Double = exponent match
    case 0 => acc
    case _ => _power(base, exponent - 1, base * acc)
  _power(base, exponent, 1)

def reverseNumber(n: Int): Int =
  def getRemainingWithoutLastDigit(n: Int): Int = n / 10
  def getLastDigit(n: Int): Int = n % 10
  @annotation.tailrec
  def _reverse(acc: Int, remaining: Int): Int = remaining match
    case 0 => acc
    case _ => _reverse(acc * 10 + getLastDigit(remaining), getRemainingWithoutLastDigit(remaining))
  _reverse(0, n)


@main
def recursion(): Unit =
  println(power(2, 3))
  println(power(5, 2))
  println(power(5, 3))

  println(powerTail(2, 3))
  println(powerTail(5, 2))
  println(powerTail(5, 3))

  println(reverseNumber(12345)) // 54321

