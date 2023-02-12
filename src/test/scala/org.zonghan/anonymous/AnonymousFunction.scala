package org.zonghan.anonymous

/**
  * Created by wuzonghan on 17/2/14.
  */
object AnonymousFunction {
  /**
    * Method to increment an integer by one.
    */
  val plusOne = (x: Int) => x + 1

  def plusOne2(x: Int) = x + 1
  /**
    * Main method
    * @param args application arguments
    */
  def main(args: Array[String]) {
    println(((x: Int) => x + 1)(0)) // Prints: 1
  }
}