package org.zonghan.testforsome

/**
  * Created by wuzonghan on 2017/6/20.
  * https://stackoverflow.com/questions/9444958/what-is-the-forsome-keyword-in-scala-for
  */
object ForSomeTest extends App {

  def printFirst(x : Array[T] forSome {type T}) = println(x(0))

  def printFirst2[T](x : Array[T]) = println(x(0))

  def addToFirst(x : Array[T] forSome {type T <: Int}) = x(0) + 1

  def addToFirst2[T <: Int](x : Array[T]) = x(0) + 1

  val x = Array("1","2")
  printFirst(x)
  printFirst2(x)

  val x1 = Array(1,2)
  println(addToFirst(x1))
  println(addToFirst2(x1))
}
