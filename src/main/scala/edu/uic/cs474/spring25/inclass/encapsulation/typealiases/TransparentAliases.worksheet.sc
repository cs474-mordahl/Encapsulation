/** By using the `type` keyword, we can create type aliases.
  */
object LeakyStudent:
  /* These are transparent aliases. These types are purely for the compiler;
   * they will be erased to their upper bound in bytecode. */
  type Name  = String
  type UIN   = String
  type NetID = String

  def findStudentByName(name: Name): LeakyStudent = ???
end LeakyStudent

// Now, in our constructor, we can use our new types.
import LeakyStudent.{Name, NetID, UIN}
case class LeakyStudent(name: Name, uin: UIN, netId: NetID)

// These types are exactly equal to String.
val name: Name = "Austin Mordahl"
val student    = LeakyStudent(name, "XXX", "amordahl")

/* This is a useful abstraction, however, it does have some problems. This is
 * what we call "leaky", where the client is aware that Name and String are
 * exactly equivalent.
 *
 * We can somewhat address this by separating the abstract interface from the
 * concrete implementation. */

trait Student:
  type Name
  type UIN
  type NetId
  type EnrollmentInfo

  def checkEnrollment(uin: UIN): EnrollmentInfo = ???
end Student

object StudentImpl extends Student:
  type Name  = String
  type UIN   = String
  type NetId = String

/* We can then define methods that take Students, and if we need to use the
 * types, we can require the client to provide the specific implementation they
 * want us to use. This requires a lot of work, though, and requires using
 * advanced features like path-dependent types. We could directly use
 * StudentImpl, but this is leaky again... */
def getEmailFromNetId(s: Student)(netId: s.NetId): Student = ??? // Too complex
def getEmailFromNetId2(netId: StudentImpl.NetId): Student  = ??? // Leaky
