package copbook.chap6

/**
 * Created by yad on 2014/06/24.
 */
object RationalDriver {
   def main(args: Array[String]) {
     val x = new Rational(1, 2)
     println(x)
     val y = new Rational(2, 3)
     println(x + y)
     println(x - y)
     println(x * y)
     println(x / y)
     val i = 5
     println(y * i)
     println(y / i)
     println(y + i)
     println(y - i)
   }
}
