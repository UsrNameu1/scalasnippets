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


