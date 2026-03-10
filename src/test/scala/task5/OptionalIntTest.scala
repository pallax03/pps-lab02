package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*

class OptionalIntTest:
  val nonEmpty = OptionalInt.Just(5)
  val empty = OptionalInt.Empty()

  @Test def emptyOptionalShouldBeEmpty(): Unit =
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    assertEquals(5, OptionalInt.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    assertEquals(1, OptionalInt.orElse(empty, 1))

  /** Task 5: do test for map **/
  @Test def mapIntShouldReturnFunctionResultWhenNonEmpty(): Unit =
    assertEquals(OptionalInt.Just(6), OptionalInt.map(nonEmpty)(_ + 1))

  @Test def mapIntShouldReturnEmpty(): Unit =
    assertEquals(OptionalInt.Empty(), OptionalInt.map(empty)(_ + 1))

  @Test def nonEmptyFilterShouldReturnOptional(): Unit =
    assertEquals(nonEmpty, OptionalInt.filter(nonEmpty)(_ > 2))

  @Test def emptyFilterShouldReturnEmptyOptional(): Unit =
    assertEquals(empty, OptionalInt.filter(empty)(_ > 2))

  @Test def nonEmptyFilterShouldReturnEmptyOptionalWithFalseFunction(): Unit =
      assertEquals(empty, OptionalInt.filter(nonEmpty)(_ < 2))