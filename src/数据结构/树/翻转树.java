package 数据结构.树;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 翻转树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
