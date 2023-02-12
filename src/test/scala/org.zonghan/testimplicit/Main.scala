package org.zonghan.testimplicit

/**
  * Created by wuzonghan on 2017/5/10.
  */
object Main extends App {
  implicit val ts = ThreadPoolStrategy

  val x = new Matrix(Array(Array(1,2,3), Array(4,5,6)))

  val y = new Matrix(Array(Array(1), Array(1), Array(1)))

  MatrixUtils.multiply(x,y)
}
