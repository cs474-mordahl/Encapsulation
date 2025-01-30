package edu.uic.cs474.spring25.inclass.encapsulation.accessModifiers.variables.qualifiers

/** Scala also allows us to qualify a variable's access modifier with one of the
  * two following things:
  *   1. A package: this means that it is accessible to members within the
  *      specified package, and private/protected to everything outside that
  *      package.
  */

package outside:
  package inside:
    class Inside1:
      private[inside] val insideVal =
        "Only members of the 'inside' package can access this."
      private[outside] val outsideVal =
        "Only members of the 'outside' package can access this."
      protected[inside] val protectedInsideVal =
        "Public to members of 'inside', protected otherwise."

    class UnrelatedToInside1:
      /* Even though this class not a subtype of Inside1, it can still access
       * protectedInsideVal since it is public to members of the inside package. */
      def accessProtected(): String = Inside1().protectedInsideVal
  end inside

  import inside.Inside1

  class Outside1:
    def getOutsideVal(): String = Inside1().outsideVal
    /* The following line won't compile, because insideVal is only visible to
     * members of the 'inside' package. */
    // def getInsideVal()  = Inside1().insideVal
  end Outside1

  class Inside1Subtype extends Inside1:
    /* Since this class is not in the 'inside' package, protectedInsideVal is
     * protected. */
    def getProtected(): String = this.protectedInsideVal

end outside

@main
def main() =
  import outside.{Outside1, Inside1Subtype}
  println(Outside1().getOutsideVal())
  println(Inside1Subtype().getProtected())
