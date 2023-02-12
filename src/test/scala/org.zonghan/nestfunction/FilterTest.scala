package org.zonghan.nestfunction

/**
  * Created by wuzonghan on 17/2/14.
  */
object FilterTest extends App {
  Thread.sleep(10000)
  def filter(xs: List[Int], threshold: Int) = {
    def process(ys: List[Int]): List[Int] =
      if (ys.isEmpty) ys
      else if (ys.head < threshold) ys.head :: process(ys.tail)
      else process(ys.tail)
    process(xs)
  }
  println(filter(List(1, 9, 2, 8, 3, 7, 4), 5))

}

// object FilterTest2 extends App {
//   def filter(xs: List[Int], threshold: Int): List[Int] = {
//     if (xs.isEmpty) xs
//     else if (xs.head < threshold) xs.head :: filter(xs.tail, threshold)
//     else filter(xs.tail, threshold)
//   }
//   println(filter(List(1, 9, 2, 8, 3, 7, 4), 5))
// }