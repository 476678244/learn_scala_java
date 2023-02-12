package org.zonghan.caseclass

/**
  * Created by wuzonghan on 17/4/17.
  */
trait Animal
case class Dog(name: String) extends Animal
case class Cat(name: String) extends Animal
case object Woodpecker extends Animal

object CaseClassTest extends App {
  def determineType(x: Animal): String = x match {
    case Dog("mmm") => "Got a Dog, name = mmm"
    case Dog(moniker) => "Got a Dog, name = " + moniker
    case _:Cat => "Got a Cat (ignoring the name)"
    case Woodpecker => "That was a Woodpecker"
    case _ => "That was something else"
  }
  println(determineType(new Dog("mmm")))
  println(determineType(new Dog("aaaa")))
  println(determineType(new Cat("Rusty the Cat")))
  println(determineType(Woodpecker))
}
