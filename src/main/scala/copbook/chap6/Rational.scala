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

package copbook.chap6


class Rational(n: Int, d:Int) {
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
}
