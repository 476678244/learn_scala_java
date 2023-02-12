package org.zonghan.leetcode


//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
object LongestSubstringWithoutRepeatingCharacters extends App {

  Array(
    lengthOfLongestSubstring(""),
    lengthOfLongestSubstring("abcbebb"),
    lengthOfLongestSubstring("bbbbb"),
    lengthOfLongestSubstring("pwwkew"),
    lengthOfLongestSubstring("aabaab!bb")
  ).foreach(println(_))


  def lengthOfLongestSubstring(s: String): Int = {
    var best = 0
    val latestPosition = new scala.collection.mutable.HashMap[Char, Int]()
    var currentQueueStart = 0
    for (idx <- 0 until s.length) {
      val value = s(idx)
      if (!latestPosition.contains(value)) {
      } else {
        (currentQueueStart until latestPosition(value)).foreach(i => {
          latestPosition.remove(s(i))
        })
        currentQueueStart = latestPosition(value) + 1
      }
      latestPosition.put(value, idx)
//      println((currentQueueStart to idx).map(s(_)).mkString(","))
      if (latestPosition.size > best) {
        best = latestPosition.size
      }
    }
    best
  }

  //*
  // "abcbebb"
  // "a" -> "ab" -> "abc" -> "cb" -> "cbe" -> "eb" -> "b"
  // *//
  def lengthOfLongestSubstring_2020(s: String): Int = {
    val left = new scala.collection.mutable.Queue[String]()
    var cursor = ""
    var currentBest = cursor
    if (s.nonEmpty)
      left ++= s.split("")
    while (left.nonEmpty) {
      val value = left.dequeue()
      if (!cursor.contains(value)) {
        cursor += value
      } else {
        cursor = cursor.substring(cursor.lastIndexOf(value) + 1) + value
      }
      if (cursor.length > currentBest.length) {
        currentBest = cursor
      }
    }
    math.max(currentBest.length, cursor.length)
  }


}

