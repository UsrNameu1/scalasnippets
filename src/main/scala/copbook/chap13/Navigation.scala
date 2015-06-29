package copbook.chap13

/*
 * Copyright (C) 2007-2008 Artima, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Example code from:
 *
 * Programming in Scala (First Edition, Version 6)
 * by Martin Odersky, Lex Spoon, Bill Venners
 *
 * http://booksites.artima.com/programming_in_scala
 */

//package bobsrockets.navigation
//class Navigator

package launch {
  class Booster3
}

package bobsrackets {


  package navigation {

    // bobsrockets.navigationパッケージ
    class Navigator {
      val map = new StarMap
    }

    class StarMap

    package launch {
      class Booster1
    }

    class MissionControl {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrackets.launch.Booster2

    }
  }

  package launch {
    class Booster2
  }

  class Ship {
    val nav = new navigation.Navigator
  }

  package fleets {
    class Fleet {
      def addShip() {
        new Ship
      }
    }
  }


}

package bobsdelights {
  abstract class Fruit(
    val name: String,
    val color: String
  )
  object Fruits {
    object Apple extends Fruit("apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellowish")
    val menu = List(Apple, Orange, Pear)
  }
}

import bobsdelights.Fruit

import bobsdelights._

import bobsdelights.Fruits._

object SomeClient {
  def showFruit(fruit: Fruit) {
    import fruit._
    println(name + "s are" + color)
  }
}

import Fruits.{Apple, Orange}
import Fruits.{Apple => Mcintosh, Orange}
import java.sql.{Date => SDate}
import java.{sql => S}
import Fruits._
import Fruits.{Apple => Mcintosh, _}
import Fruits.{Pear => _, _}

class Outer {
  class Inner {
    private def f() { println("f") }
    class InnerMost {
      f()
    }

  }
  //(new Inner).f()
}

package p {
  class Super {
    protected def f(): Unit = {
      println("f")
    }
  }
  class Sub extends Super {
    f()
  }
  class Other {
    //(new Super).f()
  }
}

package bobsrockets {
  package navigation {
    private[bobsrockets] class Navigator {
      protected[navigation] def useStarChart(): Unit = {

      }
      class LegOfJourney {
        private[Navigator] val distance = 100
      }
      private[this] var speed = 200
    }
  }

  package launch {
    import navigation._
    object Vehicle {
      private[launch] val guide = new Navigator
    }
  }
}

class Rocket {
  import Rocket.fuel
  private def canGoHomeAgain = fuel > 20
}
object Rocket {
  private def fuel = 10
  def chooseStrategy(rocket: Rocket): Unit = {
    if (rocket.canGoHomeAgain)
      goHome()
    else
      pickAStar()
  }
  def goHome(): Unit = {

  }
  def pickAStar(): Unit = {

  }
}

package object bobsdelights {
  def showFruit(fruit: Fruit): Unit = {
    import fruit._
    println(name + "s are" + color)
  }
}

package printmenu {
  import bobsdelights.Fruits
  import bobsdelights.showFruit

  object PrintMenu {
    def main(args: Array[String]): Unit = {
      for (fruit <- Fruits.menu) {
        showFruit(fruit)
      }
    }
  }
}
