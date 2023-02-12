package org.zonghan.leetcode

object ThreeSum extends App {

  /*
  * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
      示例 1：
      输入：nums = [-1,0,1,2,-1,-4]
      输出：[[-1,-1,2],[-1,0,1]]
      示例 2：
      输入：nums = []
      输出：[]
      示例 3：
      输入：nums = [0]
      输出：[]
  * */

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable
    val numsMap = nums.map(n => (n, 1)).groupBy(_._1).map(data => (data._1, data._2.length))
    val successData = new mutable.HashSet[List[Int]]()
    val sortNums = nums.sorted
    for (i <- sortNums.indices) {
      for (j <- sortNums.indices) {
        if (j > i) {
          val targetThird = 0 - sortNums(i) - sortNums(j)
          if (targetThird >= sortNums(j) && numsMap.contains(targetThird) ) {
            var needCount = 0
            if (sortNums(i) == targetThird) needCount = needCount + 1
            if (sortNums(j) == targetThird) needCount = needCount + 1
            if (numsMap(targetThird) > needCount ) {
              successData.add(List(sortNums(i), sortNums(j), targetThird))
            }
          }
        }
      }
    }
    if (numsMap.contains(0) && numsMap(0) > 2) {
      successData.add(List(0, 0, 0))
    }
    successData.toList
  }

  def threeSumV2(nums: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable
    val numsMap = nums.map(n => (n, 1)).groupBy(_._1).map(data => (data._1, data._2.length))
    val successData = new mutable.HashSet[List[Int]]()
    val sortNums = nums.distinct.sorted
    for (i <- sortNums.indices) {
      for (j <- sortNums.indices) {
        if (j > i) {
          val targetThird = 0 - sortNums(i) - sortNums(j)
          if (targetThird > sortNums(j) && numsMap.contains(targetThird) ) {
            successData.add(List(sortNums(i), sortNums(j), targetThird))
          }
        }
      }
    }
    numsMap.filter(d => d._2 > 1 && d._1 != 0).keys.foreach(same2 => {
      if (numsMap.contains(0 - same2 * 2)) {
        successData.add(List(same2, same2, 0 - same2 * 2).sorted)
      }
    })
    if (numsMap.contains(0) && numsMap(0) > 2) {
      successData.add(List(0, 0, 0))
    }
    successData.toList
  }

  var nums = Array(-1, 0, 1, 2, -1, -4)
  threeSumV2(nums).foreach(a => {
    println(a.mkString(","))
  })
  println()

//  nums = Array()
//  threeSum(nums).foreach(a => {
//    println(a.mkString(","))
//  })
//  println()
}
