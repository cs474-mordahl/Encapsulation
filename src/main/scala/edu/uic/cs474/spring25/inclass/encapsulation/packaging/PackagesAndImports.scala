package edu.uic.cs474.spring25.inclass.encapsulation.packaging

import edu.uic.cs474.spring25.inclass.encapsulation.packaging.C.Foo1

/* Scala supports a rich packaging and import system. */
/* A file may have multiple package declarations. */
package A:
  class Foo
  package B:
    class Bar:
      def doSomething(): Foo =
        /* Note that Foo() is accessible without an import, because the package
         * declaration of A and B use separate declarations. This indicates that
         * Bar() should have everything in A.B and in A in scope. */
        Foo()
    end Bar
  end B
end A

package C:
  class Foo1
package C.D:
  class Bar1:
    def doSomething(): Foo1 =
      /* Even though Bar1 is in the C package, because we did not use package
       * declarations, only things in C.D will be imported implicitly. To access
       * things in C, we need to explicitly import them. */
      import C.Foo1
      Foo1()
    end doSomething
  end Bar1
end D

// Scala's import syntax allows us to flexibly decide which things in a package we want to import. // This means, "only import E and Pi from the math package"
val x = Pi * E
/* The following line won't work, since we haven't imported pow. */
// val y = pow(x, 2)

// We can import everything using wildcard (*) syntax.
import math.*
val y = pow(x, 2)

// We can also alias things when we import them.
import math.pow as power
val z = power(3, 9)

// And, of course, we can combine both forms.
import math.{cos, sin as sine}
val a = sine(1.0)
val b = cos(1.0)
