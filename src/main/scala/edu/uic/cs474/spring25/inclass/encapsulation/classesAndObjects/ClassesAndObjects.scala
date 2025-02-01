package edu.uic.cs474.spring25.inclass.encapsulation.classesAndObjects

// Scala supports the definition of classes and "objects", which, in Scalaspeak, means singleton objects.

object CannotInitialize:
  def getString() = "I am in a singleton object."

  @main
  def main(): Unit =
    /* This does not work, since objects do not have public constructors. */
    // CannotInitialize().getString()
    /* However, objects (Scalaspeak) are objects (OOPspeak). They have a 'this'
     * variable, just like any class. */
    println(this.getString())
    /* Outside the object, we reference through the object name directly. */
    println(CannotInitialize.getString())
  end main
end CannotInitialize

/* A common misconception is that methods inside Objects are equivalent to
 * static methods in Java. **THIS IS NOT TRUE!** (Decompile the bytecode and
 * check for yourself!) In fact, Scala has only one mechanism to generate static
 * methods, and that is the @main annotation, since Java requires a static main
 * method to be the entry point of the program. Otherwise, you cannot create
 * static methods. EVERYTHING is an object in Scala (except public static void
 * main(args: String*)) */

// If a class only has one constructor, you can define it with the class.
class Circle(radius: Double)

// If you need multiple constructors, you can do so in multiple ways.
// 1. You can make a class look like it has multiple constructors by using default argument values.
class DefaultCircle(radius: Double = 1.0)
val x = DefaultCircle()    // Utilizes the default value of radius
val y = DefaultCircle(2.0) // Provides our own value to radius

// 2. You can implement multiple constructors using 'this' (NOT PREFERRED)
class ThisCircle(radius: Double):
  def this() = this(1.0)

val a = ThisCircle(2.0) // Uses the default constructor
val b = ThisCircle()    // Uses the auxilliary constructor.

// 3. You can implement 'apply' methods in the companion object (THIS IS THE WAY!)
class Rectangle private (height: Double, width: Double):
    def getHeight() = this.height
    def getWidth() = this.width

object Rectangle:
  def apply(): Rectangle =
    new Rectangle(1.0, 1.0)

  def apply(sideLength: Double): Rectangle =
    new Rectangle(sideLength, sideLength)

  def apply(height: Double, width: Double) =
    new Rectangle(height, width)
end Rectangle

/** Whenever Scala sees a call of the form <className>(...), it will expand it
  * to <className>.apply(...). If you do not provide a companion object with
  * 'apply' methods, then it will auto-generate an apply method for each public
  * constructor. However, if you provide one 'apply' method, Scala will not
  * generate *any* apply methods automatically. You can use the 'new' keyword to
  * force Scala to use a constructor.
  */
val unitRectangle = Rectangle() // syntactic sugar for Rectangle.apply()
val square        = Rectangle(2.0) // sugar for Rectangle.apply(2.0)
val rectangle     = Rectangle(1.0, 2.0) // and by now, you get it.
/* We cannot explicitly call the constructor, since it is private. */
// val fail = new Rectangle(1.0, 2.0)
/* This doesn't work, since Rectangle does not have a two-arg constructor. */
// val square2 = new Rectangle(2.0)
