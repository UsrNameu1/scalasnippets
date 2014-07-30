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
