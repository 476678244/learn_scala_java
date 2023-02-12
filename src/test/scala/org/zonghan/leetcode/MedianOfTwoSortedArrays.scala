package org.zonghan.leetcode

//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
object MedianOfTwoSortedArrays extends App {

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    def medianOfArray(nums: Array[Int]): Double = {
      val len = nums.length
      if (len == 0)
        0
      else if (len == 1)
        nums(0)
      else if (len == 2)
        (nums(0) + nums(1)).toDouble / 2
      else if (len % 2 == 1) // 0,1,2,3,4
        nums(len / 2).toDouble
      else if (len % 2 == 0) // 0,1,2,3,4,5
        (nums(len / 2 - 1) + nums(len / 2)).toDouble / 2
      else
        0
    }

    def joinTwoArrays(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
      if (nums1.isEmpty)
        return nums2
      if (nums2.isEmpty)
        return nums1
      val num3 = nums1.toList ::: nums2.toList
      num3.sorted.toArray
    }

    val num3 = joinTwoArrays(nums1, nums2)
    medianOfArray(num3)

//    println(medianOfArray(Array(1,2,3)))
//    println(medianOfArray(Array(1,2,3,4)))
//    println(num3.map(_.toString).reduce(_ + _))
  }

  val nums1 = Array(1, 3)
  val nums2 = Array(2, 4)

  println(findMedianSortedArrays(nums1, nums2))


}
