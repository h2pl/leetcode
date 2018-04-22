package 数据结构.树.递归;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 平衡树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1)return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int maxDepth(TreeNode root) {
        if (root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right ? left : right) + 1;
    }
}
