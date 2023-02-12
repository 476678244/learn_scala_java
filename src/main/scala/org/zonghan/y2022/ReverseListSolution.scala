package org.zonghan.y2022

import scala.collection.mutable.ListBuffer

object ReverseListSolution extends App {

  /*
  *     ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
  * */
  def reverseList(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    val l = new ListBuffer[ListNode]()
    l.append(head)
    var p = head.next
    while (p.next != null) {
      l.append(p)
      p = p.next
    }

    (1 until l.size).reverse.foreach(i => {
      l(i).next = l(i - 1)
    })
    p.next = l.last
    head.next = null
    p
  }

  var root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
  reverseList(root).printList()
  root = new ListNode(1)
  reverseList(root).printList()


}
