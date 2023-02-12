package org.zonghan.testoverride

/**
 * Created by wuzonghan on 2017/4/21.
 */
object Diamond extends App {
  val kittydoggy = new Cat with Dog

  println(kittydoggy.talk)

  val kittydoggy2 = new Dog with Cat

  println(kittydoggy2.talk)
}

trait Animal {
  def talk: String
}

trait Cat extends Animal {
  override def talk: String = "Meow"
}

trait Dog extends Animal {
  override def talk: String = "Woof"
}
