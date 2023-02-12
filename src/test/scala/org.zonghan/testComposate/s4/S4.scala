package org.zonghan.testComposate.s4

/**
  * Created by wuzonghan on 2017/4/26.
  */
object S4 extends App {
  val service = new DataAccess with HasNullLogger with HasRemoteLogger
  service.query("find mah datah!")
}

trait Logger {
  def log(category: String, msg: String): Unit = {
    println(msg)
  }
}

trait RemoteLogger extends Logger {
  val socket = {}
  //...


  override def log(category: String, msg: String): Unit = {
    //Send over socket }
  }
}

trait NullLogger extends Logger {
  override def log(category: String, msg: String): Unit = {}

}

trait HasLogger {
  val logger: Logger = new Logger{}
}

trait HasRemoteLogger extends HasLogger {
  override val logger: Logger = new RemoteLogger {}
}

trait HasNullLogger extends HasLogger {
  override val logger: Logger = new NullLogger {}
}

trait DataAccess extends HasLogger {

  def query(in: String) : Int = {
    logger.log("QUERY", in)
    1
  }

}
