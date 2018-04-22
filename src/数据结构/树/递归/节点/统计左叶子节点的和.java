package 数据结构.树.递归.节点;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 统计左叶子节点的和 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
