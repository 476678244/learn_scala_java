package org.zonghan.y2022

//https://leetcode-cn.com/problems/valid-parentheses/submissions/
object IsValidSolution extends App {

  /*
  * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。

    示例 1：
    输入：s = "()"
    输出：true
    示例2：
    输入：s = "()[]{}"
    输出：true
    示例3：
    输入：s = "(]"
    输出：false
    示例4：
    输入：s = "([)]"
    输出：false
    示例5：
    输入：s = "{[]}"
    输出：true
  * */
  def isValid(s: String): Boolean = {
    import scala.collection.mutable.ListBuffer
    val validPair = Map(
      '(' -> ')',
      '{' -> '}',
      '[' -> ']'
    )
    val validPairAnti = Map(
      ')' -> '(',
      '}' -> '{',
      ']' -> '['
    )
    val toRelease = new ListBuffer[Char]()
    s.toCharArray.foreach(c => {
      if (!validPair.contains(c) && !validPairAnti.contains(c)) return false
      if (validPair.contains(c)) {
        toRelease.append(c)
      }
      if (validPairAnti.contains(c)) {
        if (toRelease.isEmpty) return false
        if (validPairAnti(c) != toRelease.last) return false
        else toRelease.remove(toRelease.length - 1)
      }
    })
    if (toRelease.isEmpty) true else false
  }

  println(isValid("()"))
  println(isValid("()[]{}"))
  println(isValid("(]"))
  println(isValid("([)]"))
  println(isValid("{[]}"))

}
