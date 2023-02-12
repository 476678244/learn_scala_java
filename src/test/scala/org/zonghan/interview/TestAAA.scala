package org.zonghan.interview

import scala.collection.mutable.ListBuffer

object TestAAA extends App {

  //  println("AAA")

  /*
  * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。

    你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
    示例 1：

    输入：num1 = "11", num2 = "123"
    输出："134"
    示例 2：

    输入：num1 = "456", num2 = "77"
    输出："533"
    示例 3：

    输入：num1 = "0", num2 = "0"
    输出："0"
      提示：
      1 <= num1.length, num2.length <= 104
      num1 和num2 都只包含数字0-9
      num1 和num2 都不包含任何前导零
  * */

  def charToInt(c: Char): Int = {
    c.toInt - '0'.toInt
  }

  def sum(num1: String, num2: String): String = {
    val num1Len = num1.length
    val num2Len = num2.length
    val maxLen = math.max(num1Len, num2Len)
    //    println(maxLen)

    val num1Reverse = num1.reverse.toCharArray
    val num2Reverse = num2.reverse.toCharArray

    var extra = 0

    val result = new ListBuffer[String];
    // 456 -> 654
    // 77 -> 77
    // (3, 1)

    // 11 -> 11
    // 123 -> 321
    // 4 3 2
    (0 to maxLen).foreach(idx => {
      if (idx <= num1Len - 1 && idx <= num2Len - 1) {
        var sum = charToInt(num1Reverse(idx)) + charToInt(num2Reverse(idx))
        sum = sum + extra
        if (sum >= 10) extra = 1
        else extra = 0
        sum = sum % 10
        result.append(sum.toString)
      } else if (idx <= num1Len - 1) {
        var sum = charToInt(num1Reverse(idx)) + extra
        if (sum >= 10) extra = 1
        else extra = 0
        sum = sum % 10
        result.append(sum.toString)
      } else if (idx <= num2Len - 1) {
        var sum = charToInt(num2Reverse(idx)) + extra
        if (sum >= 10) extra = 1
        else extra = 0
        sum = sum % 10
        result.append(sum.toString)
      } else {
        result.append(extra.toString)
      }
      println(result)
    })
    result.mkString("").reverse.trim
  }

  //  val case1 = sum("11", "123")
  //  println(case1)
  //  val case2 = sum("456", "77")
  //  println(case2)
  //  val case3 = sum("0", "0")
  //  println(case3)

  // 5 5 5
  // 5 4 4
  // 0, 1 ->
  //  val case2 = sum("555", "445")
  //  println(case2)
  val case2 = sum("999", "1")
  println(case2)
}
