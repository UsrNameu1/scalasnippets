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

