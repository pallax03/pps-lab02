package tasks

enum Expr:
  case Literal(x: Int)
  case Add(x: Expr, y: Expr)
  case Multiply(x: Expr, y:Expr)

object Expr:
  def evaluate(e: Expr): Int = e match
    case Expr.Literal(x) => x
    case Expr.Add(x: Expr, y: Expr) => evaluate(x) + evaluate(y)
    case Expr.Multiply(x: Expr, y: Expr) => evaluate(x) * evaluate(y)

//  def show(e: Expr): String = e match