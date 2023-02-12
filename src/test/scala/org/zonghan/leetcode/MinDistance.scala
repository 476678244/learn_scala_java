package org.zonghan.leetcode

//https://leetcode-cn.com/problems/delete-operation-for-two-strings/
//https://leetcode-cn.com/problems/longest-common-subsequence/
object MinDistance extends App {

  //583. 两个字符串的删除操作
  def minDistance(word1: String, word2: String): Int = {
    val w1_len = word1.length
    val w2_len = word2.length

    val dp = Array.fill(w1_len+1,w2_len+1)(0)

    //word2为空串的base case
    for(i <- (0 to w1_len)){
      dp(i)(0) = i
    }

    //word1为空串的base case
    for(j <- (0 to w2_len)){
      dp(0)(j) = j
    }

    //正常遍历即可
    for(i <- (1 to w1_len) ){
      for(j <- (1 to w2_len) ){
        if(word1(i-1) == word2(j-1)){
          dp(i)(j) = dp(i-1)(j-1)
        }else{
          dp(i)(j) = math.min(dp(i-1)(j),dp(i)(j-1)) + 1
        }
      }
    }
    dp(w1_len)(w2_len)
  }


  println(minDistance("leedcode", "ceto"))
}
