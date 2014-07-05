var increase = (x: Int) => x + 1
increase(1)

val someNumbers = List(-11, -2, -1, 3, 1, 4)

someNumbers.foreach(println)
someNumbers.filter((x: Int) => x > 0)
someNumbers.filter(x => x > 0)
someNumbers.filter(_ > 0)

val f = (_: Int) + (_: Int)
f(1, 3)

def sum(a: Int, b: Int, c: Int) = a + b + c
val d = sum _
val e = sum(1, _: Int, 3)

var more = 1
val addMore = (x: Int) => x + more // bind as a ref type
addMore(10)

more = 100
addMore(23)

val otherNumbers = List(-11, -10, -5, 0, 5, 10)
var sum = 0
otherNumbers.foreach(sum += _)
sum

def makeIncreaser(more: Int)  = (x: Int) => x + more
val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)
inc1(10)
inc9999(10)

def echo(args: String*) =
  for (arg <- args) println(arg)
echo()
echo("one")
echo("one", "two", "three")
val arr = Array("AAA", "aaa")
//echo(arr)
echo(arr: _*) // 改行されず

def printTime(out: java.io.PrintStream = Console.out) =
  out.println("time = " + System.currentTimeMillis())
def printTime2(out: java.io.PrintStream = Console.out,
                divisor: Int = 1) =
  out.println("time = " + System.currentTimeMillis() / divisor)

printTime2(out = Console.err)
printTime2(divisor = 1000)

//def approximate(guess: Double): Double =
//  if (isGoodEnough(guess)) guess
//  else approximate(improve(guess))

// call many stack frame with scala sheet
def boom(x: Int): Int =
  if (x == 0) throw new Exception("boom!!")
  else boom(x - 1)

boom(5)

// call many stack frame for
def isEven(x: Int): Boolean =
  if (x == 0) true else isOdd(x - 1)
def isOdd(x: Int): Boolean =
  if (x == 0) false else isEven(x - 1)

//val funValue = newtedFun _
//def nestedFun(x: Int) {
//  if (x != 0) {println(x); funValue(x - 1) }
//}
