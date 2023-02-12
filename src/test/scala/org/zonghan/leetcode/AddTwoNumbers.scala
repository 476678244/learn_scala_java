package org.zonghan.leetcode

//https://leetcode-cn.com/problems/add-two-numbers/
object AddTwoNumbers extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }
  def listNodeToNumber(l: ListNode): Long = {
    var n = l
    var value = 0L
    var len = 0
    while (n != null) {
      value = value + n.x * math.pow(10, len).toLong
      n = n.next
      len = len + 1
    }
    value
  }

  def numberToListNode(value: BigInt): ListNode = {
    var valueS = value.toString
    val l = new ListNode(valueS(valueS.length - 1).toString.toInt)
    valueS = valueS.substring(0, valueS.length - 1)
    if (!valueS.isEmpty) {
      l.next = numberToListNode(valueS.toLong)
    }
    l
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val l1Value = listNodeToNumber(l1)
    val l2Value = listNodeToNumber(l2)
    val l3Value = l1Value + l2Value
    numberToListNode(l3Value)
  }

  def printListNode(l: ListNode): Unit = {
    var n = l
    while (n != null) {
      println(n.x)
      n = n.next
    }
  }

//  3->2->1
//  4->0->0->5->6
//  ---------------
//  3->2->1->0->0
//  4->9->0->6->5
//  ===============
//  7->1->2->6->5
  def addTwoNumbersV2(l1: ListNode, l2: ListNode): ListNode = {

    class ListNode2D(var _x: Int = 0) {
      var x: Int = _x
      var before: ListNode2D = null
      var next: ListNode2D = null
    }

    def listNodeToListNode2D(l: ListNode): (ListNode2D, Int) = {
      var n = l
      var len = 0
      val rootNode = new ListNode2D(n.x)
      var currentNode: ListNode2D = rootNode
      while (n != null) {
        len = len + 1
        if (n.next != null) {
          currentNode.next = new ListNode2D(n.next.x)
          currentNode.next.before = currentNode
        }
        currentNode = currentNode.next
        n = n.next
      }
      (rootNode, len)
    }

    @scala.annotation.tailrec
    def toEnd(l: ListNode2D): ListNode2D = if (l.next != null) toEnd(l.next) else l

    def adaptZeroToListNode2D(l: ListNode2D, len: Int): ListNode2D = {
      val rootListNode = new ListNode2D(0)
      var indexListNode = rootListNode
      (1 until len) foreach(index => {
        indexListNode.next = new ListNode2D(0)
        indexListNode.next.before = indexListNode
        indexListNode = indexListNode.next
      })
      val end = toEnd(l)
      end.next = rootListNode
      rootListNode.before = end
      l
    }

    var (l1_2D, l1_len) = listNodeToListNode2D(l1)
    var (l2_2D, l2_len) = listNodeToListNode2D(l2)
    val gap = l1_len - l2_len
    if (gap > 0) {
      l2_2D = adaptZeroToListNode2D(l2_2D, math.abs(gap))
    } else {
      l1_2D = adaptZeroToListNode2D(l1_2D, math.abs(gap))
    }

    val len = math.max(l1_len, l2_len)
    var nL1 = l1_2D
    var nL2 = l2_2D
    var sum = nL1.x + nL2.x
    var proceed =  sum / 10
    var r: ListNode = new ListNode(sum % 10)
    val result = r
    (1 until len).foreach(index => {
      nL1 = nL1.next
      nL2 = nL2.next
      sum = nL1.x + nL2.x + proceed
      proceed =  sum / 10
      r.next = new ListNode(sum % 10)
      r = r.next
    })
    if (proceed > 0) {
      r.next = new ListNode(proceed)
    }
    result
  }

//  val result = addTwoNumbers(numberToListNode(BigInt(1001)), numberToListNode(564))
  val resultV2 = addTwoNumbersV2(numberToListNode(BigInt(5)), numberToListNode(5))
  printListNode(resultV2)

}
