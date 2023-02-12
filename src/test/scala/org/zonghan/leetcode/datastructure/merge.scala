package org.zonghan.leetcode.datastructure

//https://leetcode-cn.com/problems/merge-sorted-array/submissions/
object merge extends App {

  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {

    var idx1 = m - 1
    var idx2 = n - 1

    val nums3 = Array.ofDim[Int](m + n)
    while (idx1 >=0 || idx2 >= 0) {
      if (idx1 == -1) {
        nums3(idx1 + idx2 + 1) = nums2(idx2)
        idx2 = idx2 - 1
      } else if (idx2 == -1) {
        nums3(idx1 + idx2 + 1) = nums1(idx1)
        idx1 = idx1 - 1
      } else {
        if (nums1(idx1) >= nums2(idx2)) {
          nums3(idx1 + idx2 + 1) = nums1(idx1)
          idx1 = idx1 - 1
        } else {
          nums3(idx1 + idx2 + 1) = nums2(idx2)
          idx2 = idx2 - 1
        }
      }
    }

    for(i <- nums3.indices) {
      nums1(i) = nums3(i)
    }

  }

  val nums1 = Array(1,2,3,0,0,0)
  val nums2 = Array(2,5,6)

  merge(nums1,3, nums2, 3)

  println(nums1.mkString(","))

}
