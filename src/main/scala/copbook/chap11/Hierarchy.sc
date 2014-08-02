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

42.toString

42.hashCode()

42 equals 42

42 max 43

42 min 43

1 until 5

1 to 5

3.abs

(-3).abs

def isEqual(x: Int, y: Int) = x == y

isEqual(2, 2)

def isEqual(x: Any, y: Any) = x == y

isEqual(2, 2)

val x = "abcd".substring(2)

val y = "abcd".substring(2)

x == y

x eq y

x ne y

//val i: Int = null

 def error(message: String): Nothing =
  throw new RuntimeException(message)

def divide(x: Int, y: Int): Int =
  if (y != 0) x / y
  else error("can't divide by zero")


