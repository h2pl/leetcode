package 数据结构.树.递归.树的操作;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 树的对称 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)return true;
        return recur(root.left, root.right);
    }
    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null)return true;
        if (left == null )return false;
        if (right == null )return false;
        if (left.val != right.val) return false;

        //该部分代码可以省略，因为这部分的判断是递归中已经包含了的
//        if (left.left == null && left.right == null &&
//                right.left == null && right.right == null )return true;

        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
