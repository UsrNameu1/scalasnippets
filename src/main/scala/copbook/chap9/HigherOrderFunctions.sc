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


//def containsNeg(nums: List[Int]): Boolean = {
//  var exists = false
//  for (num <- nums)
//    if (num < 0)
//      exists = true
//  exists
//}

import java.io._

def containsNeg(nums: List[Int]) = nums.exists(_ < 0)

containsNeg(List(1, 3, 4, 5))
containsNeg(List(1, -1, 4, -2))

def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)

def plainOldSum(x: Int, y: Int) = x + y
plainOldSum(1, 2)

def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(3)

val onePlus = curriedSum(1) _
onePlus(2)

def twice(op: Double => Double, x: Double) = op(op(x))
twice(_ + 1, 5)

def withPrintWriter(file: File)(op: PrintWriter => Unit) {
  var writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close ()
  }
}

val file = new File("data.txt")
withPrintWriter(file) {
  writer => writer.println(new java.util.Date)
}

var assertionEnabled = true
def myAssert(predicate: () => Boolean) =
  if (assertionEnabled && !predicate())
    throw new AssertionError

// lazy auto closure
def byNameAssert(predicate: => Boolean) =
  if (assertionEnabled && !predicate)
    throw new AssertionError

// eager
def boolAssert(predicate: Boolean) =
  if (assertionEnabled && !predicate)
    throw new AssertionError

boolAssert(4 > 1)

assertionEnabled = false

//boolAssert(1 / 0 == 0)  // this causes error
byNameAssert(1 / 0 == 0)
