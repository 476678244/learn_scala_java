package org.zonghan.oo.trait1

/**
  * Created by wuzonghan on 17/2/16.
  * 除了做為「有實作的預設介面」外，Trait 可以宣告自己只能被用在哪些情況，或者限制這個 Trait 只能被某些類別引用。
  */
object OverrideTest extends App {

  trait Swimming {
    def swim() = println("I'm swimming like a Shark")
  }

  trait Charging {
    def charge() = println("I'm charging my battery...")
  }

  class Fish

  class Toy

  class Shark extends Fish with Swimming {
    override def swim(): Unit = super.swim()
  }

  class ToyShark extends Toy with Swimming with Charging

  class Dog extends Swimming {

    override def swim() = println("I'm swimming using my four legs!")
  }
  val shark = new Shark
  val toy = new ToyShark
  val dog = new Dog
  shark.swim()

}

