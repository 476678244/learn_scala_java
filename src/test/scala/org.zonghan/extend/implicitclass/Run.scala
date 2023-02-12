package org.zonghan.extend.implicitclass

/**
  * Created by wuzonghan on 17/2/15.
  */
object Run {

  implicit class IntTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit = {
        if (current > 0) {
          f
          loop(current - 1)
        }
      }
      loop(x)
    }
  }

  implicit class LongTimes(x: Long) {
    def times(f: => Unit): Unit = {
      def loop(current: Long): Unit = {
        if (current > 0) {
          f
          loop(current - 1)
        }
      }
      loop(x)
    }
  }
}