package org.zonghan.curry

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.Stack

/**
  * Created by wuzonghan on 17/2/14.
  */
class Main extends FlatSpec with Matchers{


  "Currying" should "work" in {
    def first(x: Int) = (y: Int) => x + y

    val second = first(1)

    second(2) should be (3)
    first(2)(2) should be (4)
  }

}
