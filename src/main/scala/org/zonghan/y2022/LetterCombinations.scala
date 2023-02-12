package org.zonghan.y2022


//https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
object LetterCombinations extends App {

  /*
  * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    示例 1：
    输入：digits = "23"
    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    示例 2：
    输入：digits = ""
    输出：[]
    示例 3：
    输入：digits = "2"
    输出：["a","b","c"]
  * */

  import scala.collection.mutable.ListBuffer

  val NUM_TO_CHARS_MAP = Map(
    "2" -> List("a", "b", "c"),
    "3" -> List("d", "e", "f"),
    "4" -> List("g", "h", "i"),
    "5" -> List("j", "k", "l"),
    "6" -> List("m", "n", "o"),
    "7" -> List("p", "q", "r", "s"),
    "8" -> List("t", "u", "v"),
    "9" -> List("w", "x", "y", "z")
  )

  def letterCombinations(digits: String): List[String] = {
    if (digits.isEmpty) return List()
//    val results = new ListBuffer[String]()
//    backTrack("", digits.toCharArray, 0, digits.length, results)

//    results.toList
//    backTrackV2("", digits.toCharArray, 0, digits.length)

    digits.map(d => {NUM_TO_CHARS_MAP(d.toString)}).reduceLeft((l1, l2) => {
      l1.flatMap(letter1 => {
        l2.flatMap(letter2 => {
          List(letter1 + letter2)
        })
      })
    })
  }

  def backTrack(line: String, digits: Array[Char], appendNth: Int, totalLength: Int, results: ListBuffer[String]): Unit = {
    if (line.length == totalLength) {
      results += line
      return
    }
    NUM_TO_CHARS_MAP(digits(appendNth).toString).foreach(letter => {
      backTrack(line + letter, digits, appendNth + 1, totalLength, results)
    })
  }

  def backTrackV2(line: String, digits: Array[Char], appendNth: Int, totalLength: Int): List[String] = {
    if (line.length == totalLength) {
      return List(line)
    }
    NUM_TO_CHARS_MAP(digits(appendNth).toString).flatMap(letter => {
      backTrackV2(line + letter, digits, appendNth + 1, totalLength)
    })
  }

  println(letterCombinations("23").mkString(","))
  //
  //  println(letterCombinations("").mkString(","))
  //
  //  println(letterCombinations("2").mkString(","))
}
