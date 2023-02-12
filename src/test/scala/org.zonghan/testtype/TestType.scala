package org.zonghan.testtype

/**
  * Created by wuzonghan on 17/2/15.
  */
object TestType extends App {
  def foo[A](f: A => List[A], b: A) = f(b)
// error : def foo[A](f: A => List[A], b: Int) = f(b)
// error : def foo[A, B](f: A => List[A], b: B) = f(b)
  def foo2(x: Int) = x

  def id[T](x: T) = x
  val x = id(322)
  val x1 = id("hey")
  val x2 = id(Array(1,2,3,4))

  def f(x: AnyVal) = println(x)
  def g(x: AnyRef) = println(x)
  def h(x: Any) = println(x)
  f(1)
  g(TestType)
  h(1)

  val u = Unit
}
