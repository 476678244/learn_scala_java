package org.zonghan.leetcode

import scala.util.Random

//https://leetcode-cn.com/problems/implement-rand10-using-rand7/submissions/
object Rand7ToRand10 extends App {
  def rand7(): Int = {
    val r = new Random()
    r.nextInt(7) + 1
  }

  (1 to 100).foreach(i =>
    println(
      (rand2() - 1) * 5 + rand5()
    )
  )

  def rand2(): Int = {
    var target = 0
    while (target <= 0) {
      val opt = rand7()
      if (Set(1, 2, 3).contains(opt))
        target = 1
      if (Set(4, 5, 6).contains(opt))
        target = 2
    }
    target
  }

  def rand5(): Int = {
    var target = 0
    while (target <= 0) {
      val opt = rand7()
      if (opt <= 5)
        target = opt
    }
    target
  }


}
