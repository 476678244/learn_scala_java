package org.zonghan.collections

object ArrayTest extends App {

  val a = Array.ofDim[Int](3, 3)
  println(a.length)

  for (i <- a.indices) {
    for (j <- a(0).indices) {
      print(a(i)(j))
      a(i)(j) = i * j
    }
    println()
  }
  println()
  for (i <- a.indices) {
    for (j <- a(0).indices) {
      print(a(i)(j))
    }
    println()
  }

  val b = Array.ofDim[Int](4)
  for (i <- b.indices) {
    b(i) = i * i
  }
  for (i <- b.indices) {
    print(b(i))
  }

}
