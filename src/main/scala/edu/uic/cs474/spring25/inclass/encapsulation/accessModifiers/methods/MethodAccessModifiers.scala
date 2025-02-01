package edu.uic.cs474.spring25.inclass.encapsulation.accessModifiers.variables.methods

/** Like fields, methods can have protected and private modifiers, which mean
  * the same things they do for data. Methods may also be declared 'final,'
  * which indicates that the method may not be overridden by subtypes.
  */

class ClassWithMethods:
  final def cannotOverrideThis()       = "This method cannot be overriden."
  private def cannotAccessThis()       = "Subtypes cannot access this method."
  protected def canAccessAndOverride() = "This method is public to subtypes."

class ClassWithMethodsSubtype extends ClassWithMethods:
  // format: off
  // override def cannotOverrideThis() = "This line will produce a compiler error."
  // format: on

  def foo(): Unit =
    /* We can still call final methods from subtypes; we simply cannot override
     * them. */
    val x = this.cannotOverrideThis()

    /* Private methods, on the other hand, cannot be called from subtypes. */
    // val y = this.cannotAccessThis()

    // This works just fine.
    val z = this.canAccessAndOverride()
  end foo

  override def canAccessAndOverride(): String =
    "Note that we not only overrode this method, we also made it public."
end ClassWithMethodsSubtype

@main
def main(args: String*) =
  /* Since the canAccessAndOverride method is protected in ClassWithMethods, we
   * can't call it. */
  // println(ClassWithMethods().canAccessAndOverride())

  // However, ClassWithMethodsSubtype made the method public, so we can call it.
  println(ClassWithMethodsSubtype().canAccessAndOverride())

/** FOOD FOR THOUGHT: Is there ever any purpose to making a method private and
  * final?
  */
