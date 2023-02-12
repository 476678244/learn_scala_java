package org.zonghan.y2023

// https://leetcode.cn/problems/container-with-most-water/
object MaxArea extends App {

  /*
  * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
    找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
    返回容器可以储存的最大水量。
      说明：你不能倾斜容器。
    示例 1：
      输入：[1,8,6,2,5,4,8,3,7]
      输出：49
      解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
    示例 2：
      输入：height = [1,1]
      输出：1

  * */
  def maxArea(height: Array[Int]): Int = {
    def computeArea(i: Int, j: Int, height: Array[Int]): Int = math.min(height(i), height(j)) * (j - i)

    var currentMaxAreaValue = 0;
    var i = 0
    var j = height.length - 1
    while (i < j) {
      val areaValue = computeArea(i, j, height)
      if (areaValue > currentMaxAreaValue) currentMaxAreaValue = areaValue
      if (height(i) <= height(j)) i = i + 1 else j = j - 1
    }
    currentMaxAreaValue
  }


  val case1 = Array(1, 8, 6, 2, 5, 4, 8, 3, 7)
  println(maxArea(case1))

  val case2 = Array(1, 1)
  println(maxArea(case2))
}
