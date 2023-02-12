package org.zonghan.leetcode

object LongestBAB extends App {

  // "babad"
  // "b" -> "bab" -> "aba"
  def longestPalindrome(s: String): String = {
    def check(s: String): Boolean = {
      s match {
        case _ if s.isEmpty => false
        case _ if s.length ==1 => true
        // abba
        case _ if s.length % 2 == 0 =>
          val halfLen = s.length / 2
          (0 to halfLen).foreach(index => {
            if (!s(index).equals(s(s.length - index - 1)))
              return false
          })
          true
        // abcba
        case _ if s.length % 2 == 1 =>
          val halfLen = s.length / 2 - 1
          (0 to halfLen).foreach(index => {
            if (!s(index).equals(s(s.length - index - 1)))
              return false
          })
          true
      }
    }

    def firstMatchedForlen(s: String, len: Int): Option[String] = {
      val times = s.length - len + 1
      (1 to times).foreach(step => {
        val toCheck = s.substring(step - 1, step + len - 1)
        if (check(toCheck))
          return Option(toCheck)
      })
      None
    }

    (s.length to 0 by -1).foreach(len => {
      val trial = firstMatchedForlen(s, len)
      if (trial.isDefined)
        return trial.get
    })
    ""
  }

  println(1 to 1)
  println(1 until  1)
  println(1 to 0)
  println(1 until  0)
  println(longestPalindrome("a"))
  println(longestPalindrome("cbbd"))
  println(longestPalindrome("babad"))
}
