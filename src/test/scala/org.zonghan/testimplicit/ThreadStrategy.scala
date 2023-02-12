package org.zonghan.testimplicit

/**
  * Created by wuzonghan on 2017/5/10.
  */
trait ThreadStrategy {
  def execute[A](func : Function0[A]) : Function0[A]
}
