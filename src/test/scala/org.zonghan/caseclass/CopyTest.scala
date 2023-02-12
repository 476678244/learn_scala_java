package org.zonghan.caseclass

/**
  * Created by wuzonghan on 17/4/17.
  */
object CopyTest extends App {
  val fred = Employee("Fred", "Anchorage", "Salesman")
  val joe = fred.copy(name="Joe")
  println(fred)
  println(joe)
}

case class Employee(name: String, office: String, role: String)
