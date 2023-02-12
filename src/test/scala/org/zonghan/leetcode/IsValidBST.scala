package org.zonghan.leetcode

//https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/
object IsValidBST extends App {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def isValidBST(root: TreeNode): Boolean = {
    isValidBSTRichInfo(root)._1
  }

  def isValidBSTRichInfo(root: TreeNode): (Boolean, Int /*smallest*/ , Int /*biggest*/ ) = {

    val leftInfo = if (root.left == null) null else isValidBSTRichInfo(root.left)
    val rightInfo = if (root.right == null) null else isValidBSTRichInfo(root.right)
    val samllest = if (root.left == null) root.value else leftInfo._2
    val biggest = if (root.right == null) root.value else rightInfo._3

    val valid = (root.left == null || leftInfo._1) &&
      (root.right == null || rightInfo._1) &&
      (root.left == null || leftInfo._3 < root.value) &&
      (root.right == null || root.value < rightInfo._2)
    if (valid)
      (true, samllest, biggest)
    else
      (false, -1, -1)
  }

  val root_2 = new TreeNode(
    2,
    new TreeNode(1),
    new TreeNode(3)
  )

  println(isValidBST(root_2))


  val root_5 = new TreeNode(
    5,
    new TreeNode(1),
    new TreeNode(
      4,
      new TreeNode(3),
      new TreeNode(6)
    )
  )

  println(isValidBST(root_5))

  val root_1 = new TreeNode(
    1,
    null,
    new TreeNode(1)
  )
  println(isValidBST(root_1))
}
