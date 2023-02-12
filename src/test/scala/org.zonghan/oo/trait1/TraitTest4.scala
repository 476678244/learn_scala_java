package org.zonghan.oo.trait1

/**
  * Created by wuzonghan on 17/2/16.
  * 在這裡值得一提的，是在 Trait 中使用 super 這個關鍵字，
  * 當我們在 Trait 使用 super 這個關鍵字時，指的不是階層的關係，
  * 而是指在一連串 with XXX 的 Trait 引入順序的先後關係，
  * 而 super 會幫我們指到這串 Trait 列表的左邊的 Trait。
  *
  * 在上面的例子中我們可以看到，Trait 並不是傳統的多重繼承，而在其中 super 所指的東西會根據其引入的順序而改變。
  */
object TraitTest4 extends App {
  class Printable {
    def hello() = println("Hello World in printable")
  }

  trait Hello extends Printable {
    override def hello() = {
      println("Hello World in Hello")
      super.hello()
    }
  }

  trait CapitalHello extends Printable {
    override def hello() = {
      println("HELLO WORLD in CapitalHello")
      super.hello()
    }
  }

  val capital = new Printable with Hello with CapitalHello
  capital.hello()
}
