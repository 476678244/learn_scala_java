package booking

import scala.collection.mutable

class AwardTopKHotels {

  /*
 * Complete the 'awardTopKHotels' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. STRING positiveKeywords
 *  2. STRING negativeKeywords
 *  3. INTEGER_ARRAY hotelIds
 *  4. STRING_ARRAY reviews
 *  5. INTEGER k
 */
  def countSubstring(str: String, sub: String): Int = str.sliding(sub.length).count(_ equalsIgnoreCase  sub)

  def awardTopKHotels(positiveKeywords: String, negativeKeywords: String, hotelIds: Array[Int], reviews: Array[String], k: Int): Array[Int] = {
    val r = new mutable.HashMap[Int, Int]()
    hotelIds.sorted.distinct.foreach(id => {
      r.put(id, 0)
    })
    val p = positiveKeywords.split(" ").toSet
    val n = negativeKeywords.split(" ").toSet
    val kind = hotelIds.distinct.length
    reviews.indices.foreach(i => {
      val hotelId = hotelIds(i)
      println(i)
      val review = reviews(i)
      p.foreach(pk => {
        r.put(hotelId, r(hotelId) + countSubstring(review, pk) * 3)
      })
      n.foreach(nk => {
        r.put(hotelId, r(hotelId) + countSubstring(review, nk) * -1)
      })
    })
    println(r)
    r.toList.sortBy(_._2)(Ordering.Int.reverse).map(_._1).toArray
  }
}

object AwardTopKHotels extends App {
  val obj = new AwardTopKHotels()
  val r = obj.awardTopKHotels(
    s"""
       |breakfast beach citycenter location metro view staff price
       |""".stripMargin,
    s"""
       |not
       |""".stripMargin,
    Array(1, 2, 1, 1, 2),
    Array(
      "This hotel has a nice view of the citycenter. The location is perfect.",
      "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
      "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
      "Good price but I couldn't take my dog and there were other guests with dogs!",
      "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."
    ),
    2
  )
  println(r.mkString(","))

}
