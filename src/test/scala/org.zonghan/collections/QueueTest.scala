package org.zonghan.collections

import java.util
import java.util.concurrent.LinkedBlockingQueue


object QueueTest extends App {

  val q = new LinkedBlockingQueue[String]()
  q.add("a")
  q.add("b")

  println(q.toArray().mkString(","))

  q.put("A")
  q.put("B")

  println(q.toArray().mkString(","))

  q.offer("c")
  q.offer("d")

  println(q.toArray().mkString(","))

  println(q.take())
  println(q.take())

  println(q.toArray().mkString(","))

  println(q.peek())
  println(q.peek())

  println(q.toArray().mkString(","))

  println(q.element())
  println(q.element())


  val list = new util.LinkedList[String]()
  list.addFirst("a")
  list.addFirst("b")
  list.addFirst("c")
  list.addLast("A")
  list.addLast("B")
  list.addLast("C")
  list.removeFirst()
  list.removeLast()
  println(list.toArray().mkString(","))

}
