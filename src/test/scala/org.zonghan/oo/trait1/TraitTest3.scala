package org.zonghan.oo.trait1

/**
  * Created by wuzonghan on 17/2/16.
  */
object TraitTest3 extends App {

  class Printable {
    val a = 1
    def hello() = println("Hello World in printable")
  }

  class A

  trait C
  trait Hello extends Printable {
    override val a: Int = 2
    override def hello() = println("Hello World in Hello")
  }

  trait CapitalHello extends Printable {
    override def hello() = println("HELLO WORLD in CapitalHello")
  }

  trait B extends A with C
  // error : trait B extends C with A

  val capital = new Printable with Hello with CapitalHello
  val normal  = new Printable with CapitalHello with Hello

  capital.hello()
  normal.hello()
  println(normal.a)
}
