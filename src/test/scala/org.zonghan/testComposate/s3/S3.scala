package org.zonghan.testComposate.s3

import org.zonghan.testComposate.s2

/**
  * Created by wuzonghan on 2017/4/26.
  */
object S3 extends App {
  val a = new LoggedDataAccess{}
  println(a.query[Int]("a", 1))
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

trait LoggedDataAccess extends s2.DataAccess with s2.Logger {
  override def query[A](in: String, a : A): A = {
    log("QUERY", in)
    super.query(in, a)
  }
}
