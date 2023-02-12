package org.zonghan.oo.trait1

/**
  * Created by wuzonghan on 17/2/16.
  */
object TraitTest extends App {

  trait SelfIntroduce {
    val name: String
    def sayHello() = println("Hey, I'm " + name)
  }

  class Person(val name: String) extends SelfIntroduce
  val joe = new Person("Joe")
  joe.sayHello()

  // 編譯失敗，Fish 必須要有 name 欄位，否則要宣告成 abstract class，
  // 讓子類別來定義 name 欄位
  // class Fish extends SelfIntroduce

  // 沒問題，把 name 欄位的問題留給下一層的類別再來處理
  abstract class Fish extends SelfIntroduce

  // MyFish 繼承了 Fish 類別，也定義了 name 欄位，所以可以使用
  // SelfIntroduce 裡的 sayHello 函式了
  class MyFish(val name: String) extends Fish
  val myFish = new MyFish("Fissy")
  myFish.sayHello()
}
