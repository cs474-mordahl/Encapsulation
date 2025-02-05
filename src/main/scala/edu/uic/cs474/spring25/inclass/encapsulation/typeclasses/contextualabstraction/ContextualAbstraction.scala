package edu.uic.cs474.spring25.inclass.encapsulation.typeclasses
package contextualabstraction

/** So far, typeclasses seem like a shitty replacement for inherited methods,
  * right? We have to explictly pass them around, and it's clear that if we need
  * a lot of behaviors for a type, we need to pass in a lot of typeclass
  * instances, right?
  *
  * That's where you're wrong! Scala provides built-in support for *automatic
  * generation and passing of typeclass instances* using the using and given
  * keywords.
  *
  * Before we get into that, it is probably useful for you to know that in
  * Scala, we can define multiple parameter lists for a method.
  *
  * The utility of multiple parameters is twofold:
  *
  * First, multiple parameter lists allow us to perform partial function
  * application (this is similar to currying in functional languages, although
  * there are some differenes.)
  */

def add   = ???
def addMP = ???

/** However, the biggest use for multiple parameter lists is to differentiate
  * between explicit and implicit parameters.
  *
  * Implicit parameters will be automatically inserted by the compiler for us,
  * so we don't have to explictly add them at call sites.
  */

// Without implicit parameters:
def myToString = ???

// With implicit parameters:
def myToStringImplicit[T](t: T)(using s: Show[T]) = s.show(t)

// Now, we can call the values.
val oneAsString = ???
val twoAsString = ???

/** Huh, the compiler complains. Well, that's because, when the compiler is
  * trying to resolve an implicit parameter, it looks for the following:
  *
  *   1. First, the compiler will only find values that have been marked as
  *      "given" -- these are candiates for insertion.
  *   2. Second, the compiler will only look in the following places for given
  *      instances:
  *      a. The file in which the call is occurring
  *      b. The companion object for each class that occurs in the method call.
  *         ^^^^^ this one is what makes Scala so powerful!
  *
  * For a given typeclass T[...], we can define our common instances in the
  * companion object T, and Scala will automatically find them for us.
  *
  * Alternatively, if we are implementing a new instance of T[...] for type A,
  * we can also put the typeclass instance in the companion object for A and it
  * will also automatically find it for us!
  */
@main
def main() = ???
