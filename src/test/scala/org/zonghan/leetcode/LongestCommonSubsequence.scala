package org.zonghan.leetcode


/*
* 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

  一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

  例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
  两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
  示例 1：
  输入：text1 = "abcde", text2 = "ace"
  输出：3
  解释：最长公共子序列是 "ace" ，它的长度为 3 。
  *
  示例 2：
  输入：text1 = "abc", text2 = "abc"
  输出：3
  解释：最长公共子序列是 "abc" ，它的长度为 3 。
  *
  示例 3：
  输入：text1 = "abc", text2 = "def"
  输出：0
  解释：两个字符串没有公共子序列，返回 0 。
* */
object LongestCommonSubsequence extends App {

  //https://leetcode-cn.com/problems/longest-common-subsequence/
  def longestCommonSubsequence(text1: String, text2: String): (Int, String) = {
    val m = text1.length()
    val n = text2.length()
    var commonSub = ""
    val dp = Array.ofDim[Int](m + 1, n + 1)
    for (i <- 1 to m) {
      val c1 = text1.charAt(i - 1)
      for (j <- 1 to n) {
        val c2 = text2.charAt(j - 1)
        if (c1 == c2) {
          dp(i)(j) = dp(i - 1)(j - 1) + 1
          if (dp(i)(j) > Math.max(dp(i - 1)(j), dp(i)(j - 1))) {
            commonSub = commonSub + c2
          }
        } else {
          dp(i)(j) = Math.max(dp(i - 1)(j), dp(i)(j - 1))
        }
      }
    }
    (dp(m)(n), commonSub)
  }

//  println(longestCommonSubsequence("abcdbe", "bafcqelb"))
  // abcbe , baceb
  //
    println(longestCommonSubsequence("abcde", "ace"))
//    println(longestCommonSubsequence("aac", "aaa"))
  //  println(longestCommonSubsequence("abc", "def"))
  
}
