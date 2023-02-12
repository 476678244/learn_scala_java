package org.zonghan.y2022

import scala.collection.mutable

//https://juejin.cn/post/7046243962566213663
class LRUCacheV2Impl(capacity: Int) extends LRUCacheV2 {

  val kvMap = new mutable.HashMap[Int, LRUCacheNode]()

  var head: LRUCacheNode = _

  var tail: LRUCacheNode = _

  override def get(key: Int): Int = {
    val opt = getNode(key)
    if (opt.isDefined) {
      opt.get.value
    } else Int.MinValue
  }

  def getNode(key: Int): Option[LRUCacheNode] = {
    if (kvMap.contains(key)) {
      val node = kvMap(key)

      if (node == head) {
        head = node.next
        node.next.last = null
      } else {
        node.last.next = node.next
        node.next.last = node.last
      }
      node.next = null
      tail.next = node
      node.last = tail
      tail = node

      Some(node)
    } else None
  }

  override def put(key: Int, value: Int): Unit = {
    val existingNode = getNode(key)
    if (existingNode.isDefined) {
      existingNode.get.value = value
    } else {
      if(kvMap.size >= capacity) {
        kvMap.remove(head.key)
        if (head.next != null) {
          head.next.last = null
        }
        head = head.next
        put(key, value)
        return
      }

      val newNode = LRUCacheNode(key, value, null, null)
      if (head == null) {
        head = newNode
        tail = newNode
      } else {
        tail.next = newNode
        newNode.last = tail
        tail = newNode
      }
      kvMap.put(key, newNode)
    }
  }

  def printNodes(): Unit = {
    println("head:" + head.value)
    println("tail:" + tail.value)
    var c = head
    while (c != null) {
      print(c.value + " , ")
      c = c.next
    }
  }
}


object LRUCacheV2Impl extends App {
  val impl = new LRUCacheV2Impl(3)
  impl.put(1, 1)
  impl.put(2, 2)
  impl.put(3, 3)
  impl.put(1, 11)
  impl.put(4, 4)
  impl.printNodes()
}
