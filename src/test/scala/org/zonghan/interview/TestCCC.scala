package org.zonghan.interview

import java.util

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object TestCCC extends App {

  /*
  * problem:
  Print out or return all valid strings of N pairs of parentheses.
*  N pairs parenthese means the length of the output string is 2N (with N open and N close)
*  and open parentheses should be on the left to their matching close ones.
example:
Base case will be n=1 with the only valid output “()”.
When n=2, the output will be "()()" and "(())".          abab aabb
*   "())('' is invlid.      abba
When n=3, the output will be ["((()))","(()())","(())()","()(())","()()()"]
* // )(()()  ())(() )()()(
  * */
  var validLength = 0
  def printParen(n: Int): Unit = {
    val queue = new scala.collection.mutable.Queue[String]()
    println(validate(queue, ")"))
    println(validate(queue, "("))
    println(validate(queue, "("))
    println(validate(queue, "("))
    for (i <- 1 to n) {
      // left case
      // right case
    }
  }

  printParen(2)

  def validate(q: scala.collection.mutable.Queue[String], newChar: String): Boolean = {
    if (q.isEmpty && (newChar.equals("(") || newChar.equals(")"))) {
      validLength = validLength + 1
      q.enqueue(newChar)
      return true
    }
    if (q.last.equals(")") && newChar.equals("(")) { // (())  (
      return false
    }
    if (q.last.equals(")") && newChar.equals(")")) { // ((( ) )
      validLength = validLength - 1
      q.enqueue(newChar)
      return true
    }
    if (q.last.equals("(") && newChar.equals(")")) { // ((  )
      validLength = validLength - 1
      q.enqueue(newChar)
      return true
    }
    if (q.last.equals("(") && newChar.equals("(")) { // (( (
      validLength = validLength + 1
      q.enqueue(newChar)
      return true
    }
    // (( validLength = 2  (( )) validLength = 0
    false
  }

}
