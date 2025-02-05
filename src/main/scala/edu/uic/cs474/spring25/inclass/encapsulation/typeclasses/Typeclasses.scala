package edu.uic.cs474.spring25.inclass.encapsulation.typeclasses
// format: off
/** The typeclass pattern is originally drawn from the functional programming
  * world; however, it is very useful in both OOP and functional settings.
  *
  * The motivation of typeclasses is adding behavior to existing datatypes. In
  * languages like Haskell, where there are no "classes" that have their own
  * functions, this is a useful way to guarantee that we are able to take
  * certain actions with certain datatypes.
  * 
  * So what exactly is a typeclass? A typeclass is a class that:
  *  (1) Has no data, only methods
  *  (2) Takes at least one type parameter
  *  (3) Describes a behavior that we are fulfilling for the type parameter(s)
  * 
  * The canonical first example of a typeclass is the "Show" typeclass.
  */
// format: on

/** Below, we have the Show typeclass. The Show typeclass describes the ability
  * to represent an object as a String. In Scala, typeclasses are typically
  * described using traits and anonymous classes.
  */
trait Show[T]

/** Now, an instance of Show[T] means that we have the knowledge about how to
  * represent a type T as a String.
  */
val intShow: Show[Int]         = ???
val stringShow: Show[String]   = ???
val studentShow: Show[Student] = ???

/** Now, let's say that we want to have a general toString method that only
  * works for types that have an instance of Show defined:
  */
def myToString = ???

/** DISCUSSION: What does the typeclass pattern replace in traditional OOP? What
  * are the benefits and drawbacks?
  */

/** DISCUSSION: What are some other typeclasses that might be useful? */

/** The true power of typeclasses comes when we talk about (1) typeclass
  * derivation and (2) contextual abstraction
  */
