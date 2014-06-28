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


// 7.1

val args = Array("aa", "aaa")

var filename =
  if (args.nonEmpty) args(0)
  else "default"

println(if (args.isEmpty) args(1) else "default")
// 7.2

def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  b
}

gcdLoop(42, 56)
def greet() {
  println("hi")
}

greet() == ()
def gcd (x: Long, y: Long): Long =
  if (y == 0) x else gcd(y, x % y)
// 7.3
val filesHere = new java.io.File(".").listFiles
for (file <- filesHere)
  println(file)
for (i <- 1 to 4)
  println("Iteration " + i)
for (i <- 1 until 4)
  println("Iteration " + i)
for (file <- filesHere if file.getName.endsWith(".sh"))
  println(file)
for (
  file <- filesHere
  if file.isFile
  if file.getName.endsWith(".sh")
) println(file)
def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toList
def grep(pattern: String) =
  for (
    file <- filesHere
    if file.getName.endsWith(".sh");
    line <- fileLines(file);
    trimmed = line.trim
    if trimmed.matches(pattern)
  ) println(file + ": " + line.trim)
grep(".*gcd.*")
def shellFiles =
  for {
    file <- filesHere
    if file.getName.endsWith(".sh")
  } yield file
val forLineLengths =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(".*for.*")
  } yield trimmed.length

val n = 6
val half =
  if (n % 2 == 0)
    n / 2
  else
    throw new RuntimeException("n must be even")

import java.io.FileNotFoundException
import java.io.IOException
try {
  //val f = new FileReader("input.txt")
} catch {
  case ex: FileNotFoundException => println("file not found")
  case ex: IOException => println("IOException raised")
}

try {
} finally  {
}

import java.net.URL
import java.net.MalformedURLException
def urlFor(path: String) =
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.scala-lang.org")
  }

val firstArg = if (args.length > 0) args(0) else ""
firstArg match {
  case "salt" => println("pepper")
  case "chips" => println("salsa")
  case "eggs" => println("bacon")
  case _ => println("huh?")
}
val friend =
  firstArg match {
    case "salt" => "papper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "huh?"
  }
println(friend)

var i = 0
var foundIt = false
while (i < args.length && !foundIt) {
  if (!args(i).startsWith("-") &&
    args(i).endsWith(".scala")) {
      foundIt = true
  }
  i = i + 1
}
def searchFrom(idx: Int): Int =
  if (idx >= args.length) -1
  else if (args(idx).startsWith("-")) searchFrom(idx + 1)
  else if (args(idx).endsWith(".scala")) idx
  else searchFrom(idx + 1)
val searchresult = searchFrom(0)

//import scala.util.control.Breaks._
//import java.io._

//val in = new BufferedReader(new InputStreamReader(System.in))
//breakable {
//  while (true) {
//    println("? ")
//    if (in.readLine() == "") break
//  }
//}

def printMultiTable() {
  var i = 1

  while (i <= 10) {
    var j = 1

    while (j <= 10) {
      val prod = (i * j).toString

      var k = prod.length

      while(k < 4) {
        print(" ")
        k += 1
      }

      print(prod)
      j += 1
    }

    println()
    i += 1
  }
}

printMultiTable()

def makeRowSeq(row: Int) =
  for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }

def makeRow(row: Int) = makeRowSeq(row).mkString

def multiTable()= {
  val tableSeq =
    for (row <- 1 to 10)
    yield makeRow(row)
  tableSeq.mkString("\n")
}

println(multiTable())
