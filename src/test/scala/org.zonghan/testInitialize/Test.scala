package org.zonghan.testInitialize

/**
  * Created by wuzonghan on 2017/4/25.
  */
object Test extends App {
//  val x = new App1 { println("Now I'm initialized") }
//
//  x.main(Array())

  val x = new Property { override val name = "HI" }

  println(x)
//
//  def doSomeThing(x : Int)  {
//    x + 1
//  }
}
