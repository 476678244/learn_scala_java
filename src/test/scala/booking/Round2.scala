package booking

import scala.collection.mutable

object Round2 extends App {

  val arr = Array("1", "2", "3")
  for (i <- arr.indices) {
    print(arr(i))
  }
  println()

  val list = List("1", "2", "3")
  for (i <- list.indices) {
    print(list(i))
  }
  println()

  val map = new mutable.HashMap[Int, Int]();
  map.put(1,1)
  map.put(0,0)
  for (i <- map.keySet) {
    print(map(i))
  }
  println()
}
