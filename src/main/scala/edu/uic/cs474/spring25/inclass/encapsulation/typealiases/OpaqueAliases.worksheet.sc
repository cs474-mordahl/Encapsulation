/** Thankfully, Scala provides a mechanism for creating non-leaky type
  * abstractions without boxing overhead; these are "opaque aliases."
  *
  * By marking a type alias as "opaque", the details (i.e., the underlying type)
  * are only visible in the scope they are defined.
  */

object Student:
  opaque type Name  = String
  opaque type NetId = String
  opaque type UIN   = String

  // We provide factory methods to construct instances of these types:
  object Name:
    def apply(s: String): Name = s
  object NetId:
    def apply(s: String): NetId = s
  object UIN:
    def apply(s: String): UIN = s
end Student

/* Note that this won't compile, because outside of the Student object, we don't
 * know that String and Name are equivalent. */
// val x: Student.Name = "Austin Mordahl"
/* Instead, we use the factory methods we created. */
val x: Student.Name = Student.Name("Austin Mordahl")
