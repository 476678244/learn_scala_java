package org.zonghan.testmixin

/**
 * Created by wuzonghan on 2017/4/26.
 */
object TestMixin extends App {

  val mixin = Mixin("jijiang")
  mixin.foo("jijiang: ")

  val y = new Y {
    def foo2 = println("aaa")
  }
  y.foo("y")
  y.foo2
}

trait jijiang {
  def foo(msg: String) = {
    println(msg)
  }
}

trait mama extends jijiang {
  val str1 = "mama: "

  override def foo(msg: String) = {
    super.foo(str1.concat(msg))
  }
}

trait papa extends jijiang {
  val str2 = "papa: "

  override def foo(msg: String) = {
    super.foo(str2 + msg)
  }
}

class Mixin private (msg: String) extends jijiang {
  def this() = this("mixin")
}

class X extends jijiang with papa with mama

trait Y extends jijiang with papa with mama

object Mixin {
  // 如果包含菱形问题，则只执行最右边的
  def apply(msg: String) = new Mixin(msg) with papa with mama

  // 由于Scala的惰性求值问题，包含多重继承的父类中的成员变量名称应该不一样，否则造成编译错误

}
