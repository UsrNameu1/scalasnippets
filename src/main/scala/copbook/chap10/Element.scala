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

package copbook.chap10

/**
 * Created by yad on 2014/07/17.
 */
abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element =
    new ArrayElement(this.contents ++ that.contents)

  def beside(that: Element): Element =
    new ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  override def toString = contents mkString "\n"

  def demo() {
    println("Element's implementation invoked")
  }
}

//class ArrayElement(conts: Array[String]) extends Element {
//  def contents: Array[String] = conts
//}

final class ArrayElement (
  val contents: Array[String]
) extends Element {
  override def demo() {
    println("ArrayElement's implementation invoked")
  }
}

class LineElement(s: String) extends Element {
  val contents = Array(s)

  override def width = s.length
  override def height = 1

  override def demo() {
    println("LineElement's implementation invoked")
  }
}

class UniformElement(
  ch: Char,
  override val width: Int,
  override val height: Int
) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}
