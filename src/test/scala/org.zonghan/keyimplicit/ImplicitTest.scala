package org.zonghan.keyimplicit

/**
  * Created by wuzonghan on 17/2/15.
  * http://fangjian0423.github.io/2015/12/20/scala-implicit/
  * https://github.com/ColZer/DigAndBuried/blob/master/spark/scala-implicit.md
  */
object ImplicitTest extends App {

  val list = List(1, 2)
  val map = Map(1 -> 11, 2 -> 22, 3 -> 33)

  val newList = list.flatMap {
    num => map.get(num) // map.get方法返回的是Option，可以被隐式转换成Iterable
  }

  println(newList)

  implicit def double2Int(d: Double) = d.toInt

  val num: Int = 3.5 // 3， 这段代码会被编译成 val num: Int = double2Int(3.5)
  // 编译器可能会将x + y 转换成 convert(x) + y 如果convert被标记成implicit。
  // Scala不会把 x + y 转换成 convert1(convert2(x)) + y

  case class Club(val name: String) {
    def welcome = "Chelsea welcome you here!"
    def playerNum = 21
  }

  object Player {
    implicit def getClub(player: Player): Club = Club(player.clubName)
  }

  class Player(val name: String, val age: Int, val clubName: String) {

  }



  val p = new Player("costa", 27, "Chelsea")

  println(p.welcome) // Chelsea welcome you here!
  println(p.playerNum) // 21


  case class Person(name: String, age: Int) {
    def +(num: Int) = age + num
    def +(p: Person) = age + p.age
  }

  val person = Person("format", 99)
  println(person + 1) // 100
  //  println(1 + person)  报错，因为Int的+方法没有有Person参数的重载方法

  implicit def personAddAge(x: Int) = Person("unknown", x)

  println(1 + person) // 100
  println((1 + person).name) // 100


  case class Tiger(val name: String)
  case class Lion(val name: String)
  def implicitParamFunc(name: String)(implicit tiger: Tiger, lion: Lion): Unit = {
    println(name + " have a tiget and a lion, their names are: " + tiger.name + ", " + lion.name)
  }

  object Zoo {
    implicit val tiger = Tiger("tiger1")
    implicit val lion = Lion("lion1")
  }
  // 这里需要注意的是不仅仅方法中的参数需要被定义成隐式参数，对应的隐式参数的变量也需要被定义成隐式变量。

  import Zoo._

  implicitParamFunc("format")
}


