package org.zonghan.higherorder

/**
  * Created by wuzonghan on 17/2/14.
  */
class Decorator(left: String, right: String) {
  def layout[A](x: A) = left + x.toString() + right

  def p[I](x: I) = println(x)
}
object FunTest extends App {
  def apply(f: Int => String, v: Int) = f(v)
  val decorator = new Decorator("[", "]")
  println(apply(decorator.layout, 7))

  decorator.p[Int](1)
  decorator.p("aaa")
  decorator.p(1.1)
}