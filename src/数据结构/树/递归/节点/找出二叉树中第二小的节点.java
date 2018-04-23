package 数据结构.树.递归.节点;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 找出二叉树中第二小的节点 {
    public static void main(String[] args) {
    }
    //先找到最小值，再找第二小值
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)return -1;
        int first = findMin(root, Integer.MAX_VALUE, -1);
        int second = findMin(root, Integer.MAX_VALUE, first);
        if (second == Integer.MAX_VALUE)return - 1;
        return second;
    }
    public int findMin (TreeNode root, int min, int f) {
        if (root == null)return min;
        if (root.val < min && root.val != f)min = root.val;
        min = Math.min(findMin(root.left, min, f), min);
        min = Math.min(findMin(root.right, min, f), min);
        return min;
    }
    
}
