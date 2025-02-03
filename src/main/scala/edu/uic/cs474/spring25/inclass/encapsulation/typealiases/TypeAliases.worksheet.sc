/** Scala provides another useful construct that I forgot to introduce, which is
  * type aliasing. It's usually a good idea to have a type that corresponds to
  * each "idea" in your domain, even if it is actually equivalent to another
  * type.
  */

/** Up until now, we've been doing the following for Students:
  */
case class Student(name: String, uin: String, netId: String)

/** There's nothing inherently wrong with this definition. However, when we
  * start writing methods that consume the data in this class, the type
  * signature is not expressive enough to tell us what it takes.
  */

/** For example, consider the following method. From the name, it clearly takes
  * a UIN as the parameter. However, as far as the type system is concerned,
  * this is simply a function of the shape (String => Student).
  *
  * It would be better for documentation if we had a specialized type for UIN.
  */
def lookupStudentByUin(uin: String): Student = ???

/** Our first instinct would be to create a new case class, right?
  */
case class UIN(uin: String)

/** And this works fine, especially since we can now define methods (we could
  * even make the constructor private and define apply() methods in the
  * companion object to make sure that we only construct valid UINs.
  *
  * However, this creates a problem called "boxing," which is that everytime we
  * want to interact with the underlying string, we need to unbox it from the
  * containing object.
  */
def lookupStudent(uin: UIN): Student =
  val realUin = uin.uin
  ???

/** For times when we want to create specialized types without the overhead of
  * boxing, Scala allows us to specify *type aliases*.
  *
  * There are two different type aliases we can use: transparent aliases and
  * opaque aliases. Please go to TransparentAliases.scala to continue the lesson
  * :)
  */
