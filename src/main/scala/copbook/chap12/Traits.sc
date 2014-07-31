trait Philosophical{
  def philosophize() {
    println("I consume memory, therefore I am!")
  }
}

//class Frog extends Philosophical {
//  override def toString = "green"
//}
//
//val frog = new Frog
//frog.philosophize()
//
//val phil: Philosophical = frog
//
//phil.philosophize()

class Animal
trait HasLegs
class Frog extends Animal with Philosophical with HasLegs {
  override def toString = "green"
  override def philosophize() {
    println("It ain't easy being " + toString + "!")
  }
}

val phrog: Philosophical = new Frog
phrog.philosophize()

class Point(val x: Int, val y: Int)

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  def top = topLeft.y
  def bottom = bottomRight.y
  def height = top - bottom
}

abstract class Component extends Rectangular {

}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {

}

val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
rect.left

class Rational(n: Int, d:Int) extends Ordered[Rational] {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)

  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1) // auxiliary constructors

  def + (toRational: Rational): Rational =
    new Rational(
      numer * toRational.denom + toRational.numer * denom,
      denom * toRational.denom
    )
  def + (toInt: Int): Rational =
    new Rational(numer + toInt * denom, denom)

  def - (toRational: Rational): Rational =
    new Rational(
      numer * toRational.denom - toRational.numer * denom,
      denom * toRational.denom
    )
  def - (toInt: Int): Rational =
    new Rational(numer - toInt * denom, denom)

  def * (toRational: Rational): Rational =
    new Rational(numer * toRational.numer, denom * toRational.denom)
  def * (toInt: Int): Rational =
    new Rational(numer * toInt, denom)

  def / (toRational: Rational): Rational =
    new Rational(numer * toRational.denom, denom * toRational.numer)
  def / (toInt: Int): Rational =
    new Rational(numer, denom * toInt)

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def compare(that: Rational) =
    (this.numer * that.denom) - (that.numer * this.denom)
}

val half = new Rational(1, 2)

val third = new Rational(1, 3)

half > third

half < third

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

val queue = new BasicIntQueue

queue.put(19)
queue.put(2)
queue.get()
queue.get()

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}

class MyQueue extends BasicIntQueue with Doubling
val dQueue = new MyQueue
dQueue.put(19)
dQueue.get()

val dQueue2 = new MyQueue with Doubling
dQueue2.put(44)
dQueue2.get()

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) {super.put(x + 1)}
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}

val queue2 = new BasicIntQueue with Incrementing with Filtering

queue2.put(-1)
queue2.put(0)
queue2.put(1)

queue2.get()
queue2.get()

val queue3 = new BasicIntQueue with Filtering with Incrementing

queue3.put(-1)
queue3.put(0)
queue3.put(1)

queue3.get()
queue3.get()
queue3.get()