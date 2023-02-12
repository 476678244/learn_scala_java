package org.zonghan.option

/**
  * Created by wuzonghan on 17/4/12.
  */
object OptionTest extends App {
  val greeting: Option[String] = Some("Hello world")

  val n = None

  n.getOrElse("n")

  def getTemporaryDirectory(tmpArg: Option[String]): java.io.File = {

    tmpArg.map(name => new java.io.File(name))
      .filter(_.isDirectory)
      .getOrElse(new java.io.File(System.getProperty("java.io.tmpdir")))

  }

  val a: Option[String]= None
  val b = a.map(name => new java.io.File(name))

  val username: Option[String] = Some("Hello world")

  for(uname <- username) { println("User: " + uname) }

  val c = 0
}
