package org.zonghan.companion

/**
  * Created by wuzonghan on 17/2/15.
  */
class IntPair(val x: Int, val y: Int) {
  def getX = x
}
object IntPair {
  import math.Ordering
  implicit def ipord: Ordering[IntPair] =
    Ordering.by(ip => (ip.x, ip.y))
}

class X {
  import X._
  def blah = foo
}
object X {
  private def foo = 42
}

object Test extends App {
  val x = new X();
  println(x.blah)
  val intPair = new IntPair(1,2)
  intPair.getX
  // This illustrates another feature: in the context of private, a class and its companion are friends.
  // object X can access private members of class X, and vice versa.
  // To make a member really private to one or the other, use private[this].
}