package 数据结构.树.BST;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/25.
 */
public class 把BST每个节点的值都加上比它大的节点的值 {
    //先遍历右子树，再遍历根节点，再遍历左子树，就是从大到小遍历，
    // 每个遍历到的值加上之前的和就是新的值
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
