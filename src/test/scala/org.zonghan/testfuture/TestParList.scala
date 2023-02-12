package org.zonghan.testfuture

import scala.util.Random

object TestParList extends App {

  val sleepSeconds = new Runnable {
    override def run(): Unit = {
      println(Random.nextInt())
      Thread.sleep(1000 * 10)
    }
  }

  val sleepSeconds2 = new Runnable {
    override def run(): Unit = {
      println(Random.nextInt())
      Thread.sleep(1000 * 10)
    }
  }


  List(sleepSeconds, sleepSeconds, sleepSeconds, sleepSeconds2, sleepSeconds2, sleepSeconds2).par.foreach(_.run())

  List("1", "2", "3", "4", "5", "6").par.foreach(s => {
    println(s)
    Thread.sleep(1000 * 10)
  })
}
