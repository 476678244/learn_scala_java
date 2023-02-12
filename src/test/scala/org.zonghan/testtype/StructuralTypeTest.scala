package org.zonghan.testtype

/**
 * Created by wuzonghan on 2017/5/19.
  * http://blog.csdn.net/beckham1984/article/details/43971571
 */
object StructuralTypeTest extends App {
  def free(res: { def close(): Unit }) = {
    res.close()
  }

  free(new {
    def close() = println("close")
  })

  type Closeable = { def close(): Unit }

  def free2(res: Closeable) = {
    res.close()
  }

  free2(new {
    def close() = println("close")
  })

  trait Person

  trait Student

  type T = Person with Student { def close(): Unit }
  def free3(res: T) = {
    res.close()
  }

  free3(new Person with Student {
    def close() = println("close")
  })
}
