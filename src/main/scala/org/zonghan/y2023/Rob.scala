package org.zonghan.y2023

// https://leetcode.cn/problems/house-robber/description/
object Rob extends App {

  /*
  * 打家劫舍
  * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
  * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
  * 示例 1：
    输入：[1,2,3,1]
    输出：4
    解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
         偷窃到的最高金额 = 1 + 3 = 4 。
    示例 2：
    输入：[2,7,9,3,1]
    输出：12
    解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
         偷窃到的最高金额 = 2 + 9 + 1 = 12 。
         *
         * [2,7,9,6,1]
  * */
  def rob(nums: Array[Int]): Int = {
    val dp = new Array[Int](nums.length);
    if (nums.length == 1) return nums(0);
    if (nums.length == 2) return math.max(nums(0), nums(1))
    dp(0) = nums(0)
    dp(1) = math.max(nums(0), nums(1))
    (2 until  nums.length).foreach(idx => {
      dp(idx) = math.max(dp(idx - 2) + nums(idx), dp(idx - 1))
    })
    println(dp.mkString(","))
    dp(nums.length - 1)
  }

//  println("[1,2,3,1]:")
//  println(rob(Array(1,2,3,1)))

  println("[2,7,9,3,1]:")
  println(rob(Array(2,7,9,3,1)))

}
