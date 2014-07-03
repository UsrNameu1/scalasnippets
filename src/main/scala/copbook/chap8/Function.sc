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

