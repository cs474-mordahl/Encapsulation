package edu.uic.cs474.spring25.inclass.encapsulation.accessModifiers.classes

/** Scala classes can be modified with the 'final' and 'sealed' qualifiers.
  * 'final' indicates that the class cannot be subtyped, period, while 'sealed'
  * indicates that the class can only be subtyped in the same file.
  */

final class A
/* This won't work. */
// class B extends A

sealed class C
class D extends C // But this is fine

/** Sealed classes (or, more commonly, sealed traits) are useful to define
  * Algebraic Data Types (ADTs). These are a concept we will cover more
  * thoroughly in the functional half of the class. You can think of these as
  * data types that are a sum (OR) or product (AND) of other types.
  */
sealed trait MyList[+T] // + indicates variance, we will discuss this later.
case object Empty                                extends MyList[Nothing]
case class NonEmpty[T](head: T, tail: MyList[T]) extends MyList[T]

val listOneTwoThree =
  NonEmpty[Int](1, NonEmpty[Int](2, NonEmpty[Int](3, Empty)))

/** Here, we define List as an algebraic data type. In ADT-speak: List is a Sum
  * of two types, Empty (which is a singleton), and NonEmpty (which, itself, is
  * a product of T and List[T]
  */

/* Many things can be described as ADTs, and ADTs are a very common concept in
 * functional design.
 * For example, we can define the natural numbers as an ADT: */
sealed trait NaturalNumber
case object Zero                        extends NaturalNumber
case class NonZero(pred: NaturalNumber) extends NaturalNumber

val two   = NonZero(NonZero(Zero))
val seven = NonZero(NonZero(NonZero(NonZero(NonZero(NonZero(NonZero(Zero)))))))

/** ADTs are very useful because they are easy to compose, and naturally support
  * recursion.
  */
