package org.zonghan.higherkinded

/**
  * Created by wuzonghan on 2017/6/19.
  */
object TestHigherKinded extends App {
  type Callback[T] = Function1[T, Unit]

  val x : Callback[Int] = y => println(y + 2)

  x(2)

  def foo[M[_]](f : M[Int]) = f

  foo[Callback](x)(1)
}
