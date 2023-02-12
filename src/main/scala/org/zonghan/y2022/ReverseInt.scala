package org.zonghan.y2022

// https://leetcode.cn/problems/reverse-integer/
object ReverseInt extends App {
  /*
  * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。

示例 1：
输入：x = 123
输出：321
示例 2：=
输入：x = -123
输出：-321
示例 3：
输入：x = 120
输出：21
示例 4：
输入：x = 0
输出：0

  * */

  def reverse(x: Int): Int = {
    if (x == 0) return 0
    val absX = if (x > 0) x.toLong else 0 - x.toLong
    var raw = absX.toString.toCharArray.reverse
    while (raw.head == '0') raw = raw.drop(1)
    if (raw.mkString("").toLong > Math.pow(2, 31)) return 0
    if (x > 0) raw.mkString("").toInt else ("-" + raw.mkString("")).toInt
  }

//  println(reverse(12300))
//  println(reverse(-123))
//  println(reverse(120))
  println(reverse(-2147483648))
}
