package org.zonghan.leetcode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object NParentheses extends App {

  var validLength = 0

  val correctOnes = ListBuffer[String]()

  def printParen(n: Int): Unit = {
    val stackForQueue = new mutable.Stack[String]()
    /*
    <<<<
    <<<>
    <<><
    <<>>
    <>><
    <>>>
    <>><
    <>>>
    * */
    iterate(1, stackForQueue, n)
  }

  printParen(3)
  correctOnes.foreach(println(_))

  def iterate(depth: Int, stack: mutable.Stack[String], n: Int): Unit = {
    if (depth == n * 2) {
      var valid = validateThenAdd(stack, "(", n)
      if (valid) {
        if (validLength == 0) {
          correctOnes.append(stack.reverse.mkString(""))
        }
        stack.pop()
        validLength = validLength - 1
      }
      valid = validateThenAdd(stack, ")", n)
      if (valid) {
        if (validLength == 0) {
          correctOnes.append(stack.reverse.mkString(""))
        }
        stack.pop()
        validLength = validLength + 1
      }
    } else {
      var valid = validateThenAdd(stack, "(", n)
      if (valid) {
        iterate(depth + 1, stack, n)
        stack.pop()
        validLength = validLength - 1
      }
      valid = validateThenAdd(stack, ")", n)
      if (valid) {
        iterate(depth + 1, stack, n)
        stack.pop()
        validLength = validLength + 1
      }
    }
  }

  def validateThenAdd(stack: mutable.Stack[String], newChar: String, n: Int): Boolean = {
    if ((stack.isEmpty || validLength <= n -1) && newChar.equals("(")) {
      validLength = validLength + 1
      stack.push(newChar)
      return true
    }
    if (stack.isEmpty && newChar.equals(")")) {
      return false
    }
    if (stack.head.equals(")") && newChar.equals("(")) { // (())  (
      return false
    }
    if (stack.head.equals(")") && newChar.equals(")") && validLength >= 1) { // ((( ) )
      validLength = validLength - 1
      stack.push(newChar)
      return true
    }
    if (stack.head.equals("(") && newChar.equals(")")) { // ((  )
      validLength = validLength - 1
      stack.push(newChar)
      return true
    }
    if (stack.head.equals("(") && newChar.equals("(")) { // (( (
      validLength = validLength + 1
      stack.push(newChar)
      return true
    }
    // (( validLength = 2  (( )) validLength = 0
    false
  }

}
