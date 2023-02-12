package org.zonghan.typeclass

/**
  * Created by wuzonghan on 17/2/15.
  */
object TypeClass extends App {

  implicit def strToInt(x: String) = x.toInt

  math.max("123", 111)
}
