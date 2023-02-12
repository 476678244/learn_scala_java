package org.zonghan.oo

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by wuzonghan on 17/2/14.
  */
class Main extends FlatSpec with Matchers {


  "customerName" should "work" in {
    val customerName = new CustomerName("f", "m", "l")
    customerName.firstName should be ("f")

  }
}

case class ImmutablePerson(name: String, age: Int)
