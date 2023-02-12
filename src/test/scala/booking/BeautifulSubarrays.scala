package booking

import scala.collection.mutable

class BeautifulSubarrays {
  /*
  * 1, 2, 3, 4, 5        &&  2
  * 5 => 1,2,3,4,5 -> 3 no
  * 4 => 1,2,3,4 -> 2 yes
  * 4 => 2,3,4,5 -> 2 yes
  * 3 => 1,2,3 -> 2 yes
  * 3 => 2,3,4 -> 1 no
  * */
  def beautifulSubarrays(arr: Array[Int], numOdds: Int): Long = {
//    val r = new mutable.HashSet[(Int, Int)]()
    var r = 0
    (arr.length to 1 by -1).foreach(subArrayLen => {
      val numCheck = arr.length - subArrayLen + 1

      (0 until numCheck).foreach(i => {
        if (subArrayLen >= numOdds) {
          val isValid = valid(arr, i, i + subArrayLen - 1, numOdds)
          if (isValid) {
            //          r.add((i, i + subArrayLen - 1))
            r= r +1
          }
        }
      })
    })
//    r.size
    r
  }

  def valid(arr: Array[Int], start: Int, end: Int, numOdds: Int): Boolean = {
    //    println(Range(start, end + 1).toList)
    Range(start, end + 1).count(i => isOdd(arr(i))) == numOdds
  }

  def isOdd(n: Int): Boolean = n % 2 != 0
}

object BeautifulSubarrays extends App {
  val obj = new BeautifulSubarrays()

  //  println(obj.valid(Array(1, 2, 3, 4, 5), 0, 1, 2))

  var r = obj.beautifulSubarrays(Array(1, 2, 3, 4, 5), 2)
  println(4)
  println(r)

  r = obj.beautifulSubarrays(Array(2, 5, 4, 9), 1)
  println(6)
  println(r)
}
