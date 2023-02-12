package booking

import scala.collection.mutable.ListBuffer

class MeanderingArray {

  /*
  * 5, 2, 7, 8, -2, 25, 25
  * int n = length
  * unsorted.sort(asc).subArray(0, n /2)
  * unsorted.sort(desc).subArray(0, n/2)
  * */
  def meanderingArray(unsorted: Array[Int]): Array[Int] = {
    val asc = unsorted.sorted(Ordering.Int.reverse).toList
    val desc = unsorted.sorted.toList
    println(asc)
    println(desc)
    val r = new ListBuffer[Int]()
    val halfLen = unsorted.length / 2
    println(halfLen)
    val am = unsorted.length % 2
    println(am)
    (0 until halfLen).foreach(index => {
      r.append(asc(index))
      r.append(desc(index))
    })
    if (am == 1) {
      r.append(asc(halfLen))
    }
    r.toArray
  }
}

object MeanderingArray extends App {
  val obj = new MeanderingArray()
  var result = obj.meanderingArray(Array(5, 2, 7, 8, -2, 25, 25))
  println("25, -2, 25, 2, 8, 5, 7")
  println(result.mkString(","))

  result = obj.meanderingArray(Array(5, 2, 7, 8, -2, 25, 25, 7))
  println("25, -2, 25, 2, 8, 5, 7, 7")
  println(result.mkString(","))

  result = obj.meanderingArray(Array())
  println("")
  println(result.mkString(","))

  result = obj.meanderingArray(Array(1, 1, 1))
  println("1, 1, 1")
  println(result.mkString(","))
}
