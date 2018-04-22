package 数据结构.树.递归;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 树的高度 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right ? left : right) + 1;
    }
}
