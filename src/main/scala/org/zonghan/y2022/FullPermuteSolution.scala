package org.zonghan.y2022

//https://leetcode.cn/problems/permutations/
object FullPermuteSolution extends App {

  /*
  * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
  示例 1：
  输入：nums = [1,2,3]
  输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  示例 2：
  输入：nums = [0,1]
  输出：[[0,1],[1,0]]
  示例 3：
  输入：nums = [1]
  输出：[[1]]
  * */

  /*  input : 1,2,3,4
  *  21 34 -> 2 31 4 -> 23 41
  *           2 13 4 -> 21 43
  *  12 34 -> 31 24 -> 3 21 4 -> 32 41
  *                 -> 3124 -> 3142
  *  1234 ->
  * */

  import scala.collection.mutable.ListBuffer

  def permute(nums: Array[Int]): List[List[Int]] = {
    val res = new ListBuffer[List[Int]]()
    val numsListBuffer = new ListBuffer[Int]()
    nums.foreach(numsListBuffer.append(_))
    recurveSwap(0, nums.length, numsListBuffer, res)
    res.toList
  }

  def recurveSwap(base: Int, numsLen: Int, nums: ListBuffer[Int], res: ListBuffer[List[Int]]): Unit = {
    if (base == numsLen - 1)
      res.append(nums.toList)
    (base until numsLen).foreach(quick => {
      val swapped = if (base != quick) addSwapOption(nums, base, quick) else nums
      recurveSwap(base + 1, numsLen, swapped, res)
    })
  }

  def addSwapOption(nums: ListBuffer[Int], i: Int, j: Int): ListBuffer[Int] = {
    val swapped = new ListBuffer[Int]()
    // swap
    nums.indices.foreach(idx => {
      if (idx == i) swapped.append(nums(j))
      else if (idx == j) swapped.append(nums(i))
      else swapped.append(nums(idx))
    })
    swapped
  }

  printPermute(permute(Array(1, 2, 3, 4)))
  //    printPermute(permute(Array(0, 1)))
  //    printPermute(permute(Array(1)))

  def printPermute(p: List[List[Int]]): Unit = {
    println("size:" + p.size)
    println("distinct size:" + p.distinct.size)
    val line = p.map(_.mkString(",")).mkString(" | ")
    println(line)
  }

  //  println((1 until 4).mkString(" "))

}
