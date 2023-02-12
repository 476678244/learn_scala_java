package org.zonghan.y2023


//https://leetcode.cn/problems/generate-parentheses/
object GenerateParenthesis extends App {

  /*
  * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    示例 1：
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
    示例 2：
    输入：n = 1
    输出：["()"]
  * */
  def generateParenthesis(n: Int): List[String] = {
    import scala.collection.mutable.ListBuffer
    def appendChar(str: String, leftNum: Int, rightNum: Int, n: Int, results: ListBuffer[String]): Unit = {
      if (leftNum < n) { // check whether can append (
        appendChar(str + "(", leftNum + 1, rightNum, n, results)
      }
      if (rightNum < n) {
        if (leftNum > rightNum) {
          appendChar(str + ")", leftNum, rightNum + 1, n, results)
        }
      }
      if (leftNum == n && rightNum == n) {
        results.append(str)
      }
    }

    val results = new ListBuffer[String]()
    appendChar("", 0, 0, n, results)
    results.toList
  }


  println(s"N=${3} : ${generateParenthesis(3).mkString(",")}")

  println(s"N=${1} : ${generateParenthesis(1).mkString(",")}")

}
