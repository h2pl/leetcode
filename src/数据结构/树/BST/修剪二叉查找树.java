package 数据结构.树.BST;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 修剪二叉查找树 {
//    二叉查找树（BST）：根节点大于等于左子树所有节点，小于等于右子树所有节点。
//
//    只保留值在 L ~ R 之间的节点

    //这个解法绝了。
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        //若根节点比下限小。只保留右边。
        //若根节点比上限大，只保留左边。
        if(root.val > R) return trimBST(root.left, L, R);
        if(root.val < L) return trimBST(root.right, L, R);
        //如果根节点在中间，那么左子树也进行以上操作进行保留
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        //
        return root;
    }
//    public TreeNode trimBST(TreeNode root, int L, int R) {
//        if (root == null)return null;
//        TreeNode t = new TreeNode(root.val);
//        trimBST(root.left,L,R);
//        if (root.val < L) {
//            root = root.right;
//
//        }else if (root.val > R) {
//            root = root.left;
//        }
//        trimBST(root.right,L,R);
//        return root;
//    }
}
