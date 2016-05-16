import atomic.AtomicTest._

val v = Vector(1, 2, 3, 4)
v.map(n => n + 1) is Vector(2, 3, 4, 5)

val v2 = Vector(1, 2, 3, 4)
v2.map(n=> n*11 + 10) is Vector(21, 32, 43, 54)

val v4 = Vector(1,2,3,4)
v4.foreach(n => (n*11)+10) is Vector(21,32,43,54)//doesn't work

val v3 = for(n <- v2) yield{n * 11 + 10}
v3 is Vector(21, 32, 43, 54)

val v5 = for(n <- v2) yield {n + 1}
v5 is Vector(2, 3, 4, 5)


val v6 = Vector(1, 10, 100, 1000)
v6.reduce((sum, n) => sum + n) is 1111


var sum: Int = 0
v6.foreach(n => sum += n)
sum is 1111


def sumIt(int: Int*): Int = {
  int.reduce((sum, n) => sum + n)

}

sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195

