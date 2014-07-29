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

