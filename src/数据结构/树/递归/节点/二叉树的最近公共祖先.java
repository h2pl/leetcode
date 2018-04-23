package 数据结构.树.递归.节点;

import 数据结构.树.TreeNode;

import java.util.ArrayList;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 二叉树的最近公共祖先 {
    //    public static void main(String[] args) {
////        TreeNode t0 = new TreeNode(3);
////        TreeNode t1 = new TreeNode(5);
////        TreeNode t3 = new TreeNode(6);
////        TreeNode t4 = new TreeNode(2);
////        TreeNode t5 = new TreeNode(7);
////        TreeNode t6 = new TreeNode(4);
////
////        t4.left = t5;
////        t4.right = t6;
////        t1.left = t3;
////        t1.right = t4;
////        t0.left = t1;
////
////
////        TreeNode t7 = new TreeNode(1);
////        TreeNode t8 = new TreeNode(0);
////        TreeNode t9 = new TreeNode(8);
////
////        t7.left = t8;
////        t7.right = t9;
////        t0.right = t7;
////
////        System.out.println(lowestCommonAncestor(t0, t9, t8));
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        t1.left = t2;
//        t1.right = t3;
//        System.out.println(lowestCommonAncestor(t1, t2, t3));
//
//    }


    //复杂度是n + n + n*n*2 = n2;

    //最优解
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q) return root;
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        return left == null ? right : right == null ? left : root;
//    }


    //我的解法
    //先打印中序遍历
    //只保留两个节点中间的节点。
    //计算距离的最小值，值最小的是最近的。
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)return null;
        if (p == q)return p;
        if (p == root || q == root)return root;
        if (isParent(p,q))return p;
        if (isParent(q,p))return q;
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        int i = -1,j = -1;
        for (TreeNode t : list) {
            if (t == p)i = list.indexOf(p);
            if (t == q)j = list.indexOf(q);
            if (i != -1 && j != -1)break;
        }
        int left = i > j ? j : i;
        int right = i > j ? i : j;
        for (int n = right;n < list.size(); n ++) {
            list.remove(n);
        }
        for (int m = 0;m <= left;m ++) {
            list.remove(0);
        }
        TreeNode minNode = root;
        int min = Integer.MAX_VALUE;
        if (list.size() == 1)return list.get(0);
        for (TreeNode t : list) {
            if (isParent(t, p) && isParent(t, q)) {
                int cnt = cnt(t, p, 1) + cnt(t, q, 1);
                if (cnt < min) {
                    min = cnt;
                    minNode = t;
                }
            }
        }
        return minNode;
    }
    public static void inorder(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null)return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
        return;
    }
    public static int cnt (TreeNode root, TreeNode p, int cnt) {
        if (root == null)return 0;
        if (root == p)return cnt;
        int left = cnt(root.left, p, cnt + 1);
        int right = cnt(root.right, p, cnt +1);
        return left != 0 ? left : right;
    }
    public static boolean isParent(TreeNode t, TreeNode p) {
        if (t == p) return true;
        if (t == null) return false;
        return isParent(t.left, p) || isParent(t.right, p);
    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return null;
//        if (isParent(root, q)) return p;
//        if (isParent(q, p)) return q;
//        return inorder(root, p, q, root);
//    }
//
//    public TreeNode inorder(TreeNode root, TreeNode p, TreeNode q, TreeNode pre) {
//        if (root == null) return pre;
//        if (isParent(root, p) && isParent(root, q)) {
//            TreeNode left = inorder(root.left, p, q, root);
//            TreeNode right = inorder(root.right, p, q, root);
//            if (left != null) return left;
//            if (right != null) return right;
//        }
//        return null;
//    }

}

