package org.zonghan.leetcode

object MergeKLists {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
       var next: ListNode = _next
       var x: Int = _x
     }

  def indexOfMin(cursors: Array[ListNode]): Int = {
    var minIdx = -1
    var minValue = 10 * 10 * 10 * 10
    for (i <- cursors.indices) {
      if (cursors(i) != null && minValue > cursors(i).x) {
        minIdx = i
        minValue = cursors(i).x
      }
    }
    minIdx
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    if (lists.length == 0) {
      return null
    }

    if (!lists.find(_ != null).isDefined) {
      return null
    }

    val cursors = lists

    val selectionIdx: Int = indexOfMin(cursors)
    val startNode = cursors(selectionIdx)
    var floatingNode: ListNode = startNode
    cursors(selectionIdx) = floatingNode.next
    floatingNode.next = null

    while(cursors.find(_ != null).isDefined) {

      val selectionIdx: Int = indexOfMin(cursors)

      floatingNode.next = cursors(selectionIdx)
      cursors(selectionIdx) = cursors(selectionIdx).next

      floatingNode = floatingNode.next
      floatingNode.next = null

    }

    startNode
  }
}
