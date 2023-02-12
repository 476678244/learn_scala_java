package org.zonghan.leetcode.datastructure


//https://leetcode-cn.com/problems/two-sum/
object TwoSum extends App {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    import java.util
    val sortNums = nums.sorted
    nums.indices.foreach(i => {
      if (nums(i) * 2 == target) {
        if (sortNums.indexOf(nums(i)) != sortNums.lastIndexOf(nums(i))) {
          return Array(nums.indexOf(nums(i)), nums.lastIndexOf(nums(i)))
        }
      } else {
        val rightOpt = util.Arrays.binarySearch(sortNums, target - nums(i))
        if (rightOpt > 0) {
          return Array(nums.indexOf(nums(i)), nums.lastIndexOf(target - nums(i)))
        }
      }
    })
    Array(0, 0)
  }

  var nums: Array[Int] = Array(0)
  var target = 0

  //  nums = Array(2, 7, 11, 15)
  //  target = 9
  //  println(twoSum(nums, target).mkString("Array(", ", ", ")"))

  //  nums = Array(3, 2, 4)
  //  target = 6
  //  println(twoSum(nums, target).mkString("Array(", ", ", ")"))

  nums = Array(-3, 4, 3, 90)
  target = 0
  println(twoSum(nums, target).mkString("Array(", ", ", ")"))
}
