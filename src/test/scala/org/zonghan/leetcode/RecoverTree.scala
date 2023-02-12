package org.zonghan.leetcode

/* https://leetcode-cn.com/problems/recover-binary-search-tree/
给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
*/

object RecoverTree extends App {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def printTree(root: TreeNode): String = {
    Array(root.value,
      if (root.left == null) "null" else printTree(root.left),
      if (root.right == null) "null" else printTree(root.right)
    ).mkString(",")
  }

  val root = new TreeNode(3,
    new TreeNode(1, null, null),
    new TreeNode(4,
      new TreeNode(2), null
    )
  )

//  val root = new TreeNode(1,
//    new TreeNode(3, null, new TreeNode(2)),
//    null
//  )

  def recoverTree(root: TreeNode): Unit = {
  }

  println(printTree(root))
  recoverTree(root)
  println(printTree(root))

}
