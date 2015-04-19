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
