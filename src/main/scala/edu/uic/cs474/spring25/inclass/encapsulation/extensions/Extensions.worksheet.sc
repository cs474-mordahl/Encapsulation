/* Scala provides a really useful mechanism for dynamically adding methods to
 * classes that you don't have access to. These are called extension methods.
 *
 * For example, consider that you have some domain where it is useful to get
 * every other member of a list.
 * We could define that method as follows: */
object ListUtils:
  def getEveryOtherMember[T](input: List[T]): List[T] =
    for
      (k, ix) <- input.zipWithIndex
      if ix % 2 == 0
    yield k
end ListUtils

ListUtils.getEveryOtherMember(List(0, 1, 2, 3, 4, 5, 6))

/* This works, but wouldn't it be nice if Lists had this method so that we could
 * do the following:
 *
 * List(0, 1, 2, 3, 4, 5, 6).getEveryOtherMember()
 *
 * Well, with extension methods, we can do that! */
extension [T](li: List[T])
  def getEveryOtherMember(): List[T] = ListUtils.getEveryOtherMember(li)

/* Now, we have access to this method. */
List('a', 'b', 'c', 'd', 'e').getEveryOtherMember()
