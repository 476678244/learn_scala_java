package org.zonghan.testInitialize

/**
 * Created by wuzonghan on 2017/4/25.
 */
trait App1 extends DelayedInit {
  var x: Option[Function0[Unit]] = None
  override def delayedInit(cons: => Unit) {
    x = Some(() => cons)
  }

  def main(args: Array[String]): Unit = x.foreach(_())
}
