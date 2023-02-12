package org.zonghan.testimplicit

/**
  * Created by wuzonghan on 2017/5/10.
  */
object SameThreadStrategy extends ThreadStrategy {
  def execute[A](func : Function0[A]) = func
}
