package org.zonghan.testComposate.s1

/**
  * Created by wuzonghan on 2017/4/26.
  */
class S1 {

}

trait Logger {
  def log(category: String, msg: String): Unit = {
    println(msg)
  }
}

trait DataAccess {
  val logger = new Logger {}

  def query[A](in: String, a : A): A = {
    logger.log("QUERY", in)
    //...
    a
  }

}
