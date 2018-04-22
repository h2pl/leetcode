package 数据结构.树.递归.路径;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 两节点的最长路径 {
    //从任一个节点出发找两边最长的边，相加即为该点为中心的最长路径。
    //遍历一遍二叉树找出这些路径中最长的。
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)return 0;
        int left = recur(root.left, 0);
        int right = recur(root.right, 0);
        int max = left + right;
        max = Math.max(max, diameterOfBinaryTree(root.left));
        max = Math.max(max, diameterOfBinaryTree(root.right));
        return max;
    }
    public int recur (TreeNode root, int sum) {
        if (root == null)return sum;
        if (root.left == null && root.right == null) return sum + 1;
        int left = recur(root.left, sum + 1);
        int right = recur(root.right, sum + 1);
        return Math.max(left, right);
    }

}
