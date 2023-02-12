package org.zonghan.testIterable

/**
  * Created by wuzonghan on 2017/7/5.
  */
object TestIterable extends App {
  val names = scala.collection.Iterable("a", "b")
  names.iterator.hasNext
  println(names.iterator.next())

  val addresses = Iterable("a1", "b1")

  val zipped = names.iterator.zip(addresses.iterator)
  println(zipped.next())
}
