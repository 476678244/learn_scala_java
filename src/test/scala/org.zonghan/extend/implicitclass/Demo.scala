package org.zonghan.extend.implicitclass

/**
  * Created by wuzonghan on 17/2/15.
  */
import Run._

object Demo {
  def main(args: Array[String]) {
    4 times println("hello")

    4L times(println("hello long"))
  }
}