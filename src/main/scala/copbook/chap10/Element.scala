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
  import Element.elem

  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val extendedThis = this widen that.width
    val extendedThat = that widen this.width
    elem(extendedThis.contents ++ extendedThat.contents)
  }

  def beside(that: Element): Element = {
    val extendedThis = this heighten that.height
    val extendedThat = that heighten this.height
    elem(
      for ((line1, line2) <- extendedThis.contents zip extendedThat.contents)
      yield line1 + line2
    )
  }

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"

}

object Element {

  private class ArrayElement (
                               val contents: Array[String]
                               ) extends Element

  private class LineElement(s: String) extends Element {
    val contents = Array(s)

    override def width = s.length
    override def height = 1
  }

  private class UniformElement (
                                 ch: Char,
                                 override val width: Int,
                                 override val height: Int
                                 ) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)
  def elem(line: String): Element =
    new LineElement(line)

}
