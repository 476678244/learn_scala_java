package org.zonghan.equal

import scala.collection.immutable.HashMap

/**
  * Created by wuzonghan on 17/4/12.
  */
object Point2Test extends App {

  val x = new Point2(1,1)

  val y = new Point2(1,2)

  val z = new Point2(1,1)

  println(x == y)

  println(x == z)

  println(x eq z)

  println(x.##)

  val map = HashMap(x -> "HAI", y -> "WORLD")

  x.move(1,1)

  println(map(z))
}
