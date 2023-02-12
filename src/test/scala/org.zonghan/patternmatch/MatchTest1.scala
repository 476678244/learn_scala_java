package org.zonghan.patternmatch

/**
  * Created by wuzonghan on 17/2/14.
  */
object MatchTest1 extends App {
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
  println(matchTest(3))
}

object MatchTest2 extends App {
  def f(x:Int) = x +1
  val plusOne = (x: Int) => x + 1
  plusOne.getClass
  plusOne(1)
  type T = Int => Int
  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"

  }
  println(matchTest("two"))
}


