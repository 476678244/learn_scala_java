package org.zonghan.testComposate.s2

/**
  * Created by wuzonghan on 2017/4/26.
  */
class S2 {

}

trait Logger {
  def log(category: String, msg: String): Unit = {
    println(msg)
  }
}

trait DataAccess {
  def query[A](in: String, a : A): A = {
    //...
    a
  }
}

trait LoggedDataAccess {

  val logger = new Logger {}
  val dao = new DataAccess {}

  def query[A](in: String , a : A): A = {
    logger.log("QUERY", in)


    dao.query(in, a)
    a

  }

}