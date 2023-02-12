package org.zonghan.leetcode

object ScalaSearchRange extends App {

  /*
    * 在排序数组中查找元素的第一个和最后一个位置
    * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    * Example:
    *   nums: [5, 7, 7, 8, 8, 10]
    *   target: 8
    *   answer: [3,4]
    * 如果数组中不存在目标值 target，返回 [-1, -1]
    * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
    * */

  def searchRangeV2(nums: Array[Int], target: Int): Array[Int] = {
//    println(nums.length)
    if (nums == null || nums.length == 0)
      return Array(-1, -1)
    val l = searchLeft(nums, target)
    val r = searchRight(nums, target)
    Array(l, r)
  }

  // 5,6,6,8,8,10
  // 5,6,7,8,8,10
  def searchLeft(nums: Array[Int], target: Int): Int = {
    var l = 0
    var r = nums.length - 1
    while (l < r) {
      val mid = l + (r - l) / 2
      if (nums(mid) == target) {
        r = mid
      } else if (nums(mid) > target) {
        r = mid - 1
      } else {
        l = mid + 1
      }
    }
    if (target == nums(l)) l else -1
  }

  def searchRight(nums: Array[Int], target: Int): Int = {
    var l = 0
    var r = nums.length - 1
    while (l < r) {
      val mid = l + (r - l + 1) / 2
      if (nums(mid) == target) {
        l = mid
      } else if (nums(mid) > target) {
        r = mid - 1
      } else {
        l = mid + 1
      }
    }
    if (target == nums(r)) r else -1
  }

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    import java.util
    val existIdx = util.Arrays.binarySearch(nums, target)
    if (existIdx < 0) Array(-1, -1) else {
      Array(findOtherViaLast(nums, existIdx, target), findOtherViaNext(nums, existIdx, target))
    }
  }

  def findOtherViaNext(nums: Array[Int], idx: Int, target: Int): Int = {
    if (idx == nums.length - 1)
      idx
    else if (nums(idx + 1) != target)
      idx
    else findOtherViaNext(nums, idx + 1, target)
  }

  def findOtherViaLast(nums: Array[Int], idx: Int, target: Int): Int = {
    if (idx == 0)
      idx
    else if (nums(idx - 1) != target)
      idx
    else findOtherViaLast(nums, idx - 1, target)
  }

  println(searchRangeV2(Array(5, 7, 7, 8, 8, 10), 8).mkString(","))
  println(searchRangeV2(Array(5, 7, 7, 8, 8, 8, 10), 8).mkString(","))
  println(searchRangeV2(Array(1), 1).mkString(","))
  println(searchRangeV2(Array(), 8).mkString(","))
  println(searchRangeV2(Array(2, 2), 2).mkString(","))
}

