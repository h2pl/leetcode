package 数据结构.树.递归.节点;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 二叉查找树的最近公共祖先 {
    //根据查找树的性质，如果节点值在这两个值中间，就是最近公共祖先。
    //若比两个节点都大，找左子树，否则找右子树。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)return null;
        if (root.val >= p.val && root.val <= q.val || root.val <= p.val && root.val >= q.val ) {
            return root;
        }else if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
