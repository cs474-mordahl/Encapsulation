package edu.uic.cs474.spring25.inclass.encapsulation.accessModifiers.variables

// format: off
/** Scala provides two general access modifiers for data.
  *
  * protected: Specifies that the data is only accessible by the owning class,
  *            as well as any subtypes of the owning class.
  *
  * private: Specifies that the data is only accessible in the owning class, and
  *          not in any subtypes.
  */
// format: on

class VariableAccessModifiers:
  protected val secret         = "This is a secret."
  private val biggerSecret     = "This is an even bigger secret."
  final val cannotBeOverridden = "This cannot be overriden by a subtype."

  def getSecret(): String       = this.secret
  def getBiggerSecret(): String = this.biggerSecret

class VariableAccessModifiersSubtype extends VariableAccessModifiers:
  /* Like methods, we can also override the value of fields inherited from
   * subtypes. */
  override protected val secret: String =
    "Dark Souls 2 is the best Dark Souls game."

  /* However, the `final` keyword prevents subtypes from being able to override. */
  // override val cannotBeOverridden: String = "This won't compile."

  /* Note that the subtype still has access to final fields (as long as they are
   * not private); it simply cannot override them. */
  def getFinal(): String = this.cannotBeOverridden

  override def getSecret(): String = this.secret

  /* Note that the following line won't compile, because
   * VariableQualifiersSubtype does not have access to biggerSecret. */
  // override def getBiggerSecret(): String = this.biggerSecret

  /* HOWEVER, because VariableQualifiersSubtype is a subtype of
   * VariableQualifiers, it still inherits the getBiggerSecret() method and can
   * access it in that way. */
end VariableAccessModifiersSubtype

@main
def main() =
  /* Note that we can still access the private val in the subclass via the
   * public getter. */
  println(VariableAccessModifiersSubtype().getBiggerSecret())
