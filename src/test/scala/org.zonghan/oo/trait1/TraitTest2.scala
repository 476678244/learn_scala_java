package org.zonghan.oo.trait1

/**
  * Created by wuzonghan on 17/2/16.
  * 除了使用未定義的欄位來限制外，也可以使用 trait TraitA extends BaseClass 這樣的語法指定 TraitA 只能被 BaseClass 類別和其子類別引入。
  * 但這邊要注意的是，這裡的 extends 並不是繼承關係，而只是代表 TraitA 可以被引入的限制範圍。
  * 在這個情況下，TraitA 裡面可以參照到 BaseClass 的成員函式和成員變數。
  *  (mixin)
  */
object TraitTest2 extends App {
  class BaseClass {
    def sayHello(content: String) = println(content)
  }

  class SubClass extends BaseClass {
    override def sayHello(content: String) = {
      println("Inside SubClass:" + content)
    }
  }
  trait A

  class B

  class C

  class AnotherClass

  trait UpperCase extends BaseClass with A {
    def greet() {
      println("Greeting from UpperCase")
      sayHello("Hello!")
    }
  }

  // 沒問題，UpeerCase 可以被 BaseClass 類別引入
  val base = new BaseClass with UpperCase
  base.greet()

  // 沒問題，UpperCase 可以被 BaseClass 的子類別引入
  val sub = new SubClass with UpperCase with A
  sub.greet()

  // 編譯錯誤，AnotherClass 並不是 BaseClass 的子類別，
  // 所以不能使用 UpperCase
  //
  // val another = new AnotherClass with UpperCase
}
