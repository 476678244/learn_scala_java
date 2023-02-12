package org.zonghan.oo.trait1

/**
  * Created by wuzonghan on 17/2/16.
  * http://www.codedata.com.tw/java/scala-tutorial-7-trait/
  * DecoratorPattern using trait
  */
object DecoratorPattern extends App {
  // 基礎類別
  class Printable {
    def print(content: String) = println(content)
  }

  // 因為這些是裝飾者物件，我們只能讓他們可以被 Printable 類別引用
  trait Repeat extends Printable {
    override def print(content: String) = {
      super.print(content + "\n" + content + "\n" + content)
    }
  }

  trait UpperCase extends Printable {
    override def print(content: String) = {
      super.print(content.toUpperCase)
    }
  }

  trait LowerCase extends Printable {
    override def print(content: String) = {
      super.print(content.toLowerCase)
    }
  }

  trait Filter extends Printable {
    override def print(content: String) = {
      super.print(content.replace("shit", "XXXX"))
    }
  }

  // 大寫並且印三次
  val upperAndRepeat = new Printable with Repeat with UpperCase
  upperAndRepeat.print("Hello World")

  // 小寫並且過濾
  val filterAndLower = new Printable with LowerCase with Filter
  filterAndLower.print("It looks like a shit")

}
