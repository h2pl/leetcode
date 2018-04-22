package 数据结构.树.递归.树的操作;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 归并两棵树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)return t2;
        if (t2 == null)return t1;
        TreeNode t = new TreeNode(t1.val);
        t.val = t1.val + t2.val;
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);
        return t;
    }

}
