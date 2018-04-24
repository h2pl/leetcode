package 数据结构.树.递归.路径;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 相同节点值的最大路径长度 {
    private int path = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
    //不知道哪里做错了，很烦
//    public int longestUnivaluePath(TreeNode root) {
//        if (root == null) return 0;
//        int max = 0;
//        int left = 0,right = 0;
//        if (root.left != null && root.val == root.left.val) {
//            left ++;
//        }
//        if (root.right != null && root.val == root.right.val) {
//            right ++;
//        }
//        left = recur(root.left, left);
//        right = recur(root.right, right);
//        max = left + right;
//        max = Math.max(longestUnivaluePath(root.left), max);
//        max = Math.max(longestUnivaluePath(root.right), max);
//        return max;
//    }
//    public int recur (TreeNode t,int cnt) {
//        if (t == null)return cnt;
//        int left = cnt;
//        int right = cnt;
//        if (t.left != null && t.val == t.left.val) {
//            left = recur(t.left, cnt + 1);
//        }
//        if (t.right != null && t.val == t.right.val) {
//            right = recur(t.right, cnt + 1);
//        }
//        return left > right ? left : right;
//    }
}
