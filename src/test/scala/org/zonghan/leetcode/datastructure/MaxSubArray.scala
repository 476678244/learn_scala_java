package org.zonghan.leetcode.datastructure

import scala.collection.mutable.ListBuffer

//https://leetcode-cn.com/problems/maximum-subarray/
object MaxSubArray extends App {

  /*给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。*/
  /*输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。*/
  def maxSubArrayV2(nums: Array[Int]): Int = {
    //[-2,4,-3,4]
    // -2 => 0
    // -2,4 => 4, 4 > 0
    // -2,4,-3 => 1, 4 > 1
    // -2,4,-3,4 => 5, 5> 4
    // fi = math.max(f1_1 + x, x)
    var fi_1 = 0
    var totalMax = nums(0)
    for (x <- nums) {
      fi_1 = math.max(fi_1 + x, x)
      totalMax = math.max(fi_1, totalMax)
    }
    totalMax
  }

  def maxSubArray(nums: Array[Int]): Int = {
    // dp(i)(j) = dp(i)(j-1) + nums(j)
    // dp(i)(j) = dp(i-1)(j) - nums(i-1)
    val dp = Array.ofDim[Int](nums.length, nums.length)
    dp(0)(0) = nums(0)
    var totalMax = dp(0)(0)
    for (x <- nums.indices) {
      for (y <- nums.indices) {
        if (y > x) {
          if (y == x + 1 && x != 0) {
            dp(x)(y) = dp(x - 1)(y) - nums(x - 1)
          } else {
            dp(x)(y) = dp(x)(y - 1) + nums(y)
          }
          if (dp(x)(y) > totalMax) {
            totalMax = dp(x)(y)
          }
        }
      }
    }
    math.max(totalMax, nums.max)
  }

//  println(maxSubArrayV2(Array(-2,1,-3,4,-1,2,1,-5,4)))
//
//  println(maxSubArrayV2(Array(-2, 1)))

  println(maxSubArrayV2(Array(-1)))

}
