package org.zonghan.leetcode

import scala.collection.mutable

//https://leetcode-cn.com/problems/two-sum/
object SumTwo extends App {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    nums.indices.foreach(i => {
      nums.indices.foreach(j => {
        if (i != j) {
          if ((nums(i) + nums(j)) == target)
            return Array(i, j)
        }
      })
    })
    Array(-1, -1)
  }

  def twoSumV2(nums: Array[Int], target: Int): Array[Int] = {
    val cache = new mutable.HashMap[Int, Int]()
    nums.indices.foreach(i => {
      if (cache.contains(nums(i))) {
        if (nums(i) * 2 == target)
          return Array(cache(nums(i)), i)
        else
          cache.remove(nums(i))
      } else
        cache.put(nums(i), i)
    })
    nums.indices.foreach(i => {
      cache.remove(nums(i))
      val opt = target - nums(i)
      if (cache.contains(opt))
        return Array(i , cache(opt))
    })
    Array(-1, -1)
  }

  val nums = Array(3,2,4)
  twoSumV2(nums, 6).foreach(println(_))
}


