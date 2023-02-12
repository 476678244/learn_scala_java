package org.zonghan.y2022

//https://leetcode.cn/problems/jump-game/solutions/203549/tiao-yue-you-xi-by-leetcode-solution/
object CanJump extends App {

  /*
  * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标。
    示例 1：
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    示例 2：
    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
  * */

  def canJumpCorrect(nums: Array[Int]): Boolean = {
    var longestPoint = 0;
    nums.zipWithIndex.foreach(data => {
      val (num, idx) = data
      if (longestPoint >= nums.length - 1) {
        return true
      }
      if (longestPoint >= idx) { // can reach idx
        if (idx + num > longestPoint) {
          longestPoint = idx + num
        }
      } else return false
    })
    false
  }

  // wrong solution
  def canJump(nums: Array[Int]): Boolean = {
    jump(nums, 0)
  }

  def jump(nums: Array[Int], idx: Int): Boolean = {
    if (idx == nums.length - 1) return true
    if (nums(idx) == 0) return false
    if (idx <= nums.length - 1) {
      (1 to nums(idx)).foreach(len => {
        if ((idx + len) > nums.length) return false
        if (jump(nums, idx + len)) return true
      })
    }
    idx == nums.length - 1
  }


  println(s"can jump (0) : ${canJumpCorrect(Array(0))}")

//  println(s"can jump (2,3,1,1,4) : ${canJumpCorrect(Array(2, 3, 1, 1, 4))}")
//  //
//  println(s"can jump (2,3,1,1,4) : ${canJumpCorrect(Array(3, 2, 1, 0, 4))}")
//
//  println(s"(List(97) ::: (97 to 0).by(-1).toList ::: List(0)).toArray : ${
//    canJumpCorrect(
//      (List(97) ::: (97 to 0).by(-1).toList ::: List(0)).toArray
//    )
//  }")
}
