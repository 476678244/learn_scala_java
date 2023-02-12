package org.zonghan.cpng;

public class IsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
    * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
        有效 二叉搜索树定义如下：
            节点的左子树只包含 小于 当前节点的数。
            节点的右子树只包含 大于 当前节点的数。
            所有左子树和右子树自身必须也是二叉搜索树。
        示例 1：
        输入：root = [2,1,3]
        输出：true
        * https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg
        示例 2：
        输入：root = [5,1,4,null,null,3,6] // 宽度优先遍历
        输出：false
        * https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg

        解释：根节点的值是 5 ，但是右子节点的值是 4 。

        提示：
            树中节点数目范围在[1, 104] 内
            -231 <= Node.val <= 231 - 1
    * */
    public static void main(String[] args) {
        IsValidBST obj = new IsValidBST();
        TreeNode case1 = new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3)
        );
        System.out.println(obj.isValidBST(case1)); // true

        TreeNode case2 = new TreeNode(
                5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6))
        );
        System.out.println(obj.isValidBST(case2)); // false

        TreeNode case3 = new TreeNode(
                1,
                null,
                new TreeNode(1)
        );

        System.out.println(obj.isValidBST(case3)); // false

    }

    public boolean isValidBST(TreeNode root) {
        return false;
    }
}
