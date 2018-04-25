package 数据结构.树.层次遍历;

import 数据结构.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 间隔遍历 {
    //前三行的抢法，要么抢13要么抢2，抢2的时候可以选择抢24或者抢3。。以此类推。
    //得到最大值。这个题要记
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }
    //思路有问题，告辞
//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//        int depth = depth(root);
//        int max = 0;
//        if (depth == 2) {
//            max = Math.max(recur(root, 1), max);
//            max = Math.max(recur(root, 2), max);
//            return max;
//        }
//        int []visit = new int[depth + 1];
//        visit[0] = 1;
//        for (int i = 1;i <= depth;i ++) {
//            max = dfs(root, i, depth, 0, visit);
//        }
//
//    }
//    public int dfs(TreeNode t,int cur,int depth, int cnt, int []visit) {
//        if (t == null)return 0;
//
//        cnt += recur(t,cur);
//        visit[cur] = 1;
//
//        for (int i = 1;i <= depth ;i ++) {
//            if (i - 1 == 0 && visit[i] != 1 && visit[i + 1] != 1) {
//                cnt = dfs(t, i, depth, cnt, visit);
//            }
//            if (i + 1 == depth + 1 && visit[i] != 1 && visit[i - 1] != 1) {
//                cnt = dfs(t, i, depth, cnt, visit);
//            }
//            if (visit[i] != 1 && i - 1 >= 1 && visit[i - 1] != 1 && visit[i + 1] != 1) {
//                cnt = dfs(t, i, depth, cnt, visit);
//            }
//        }
//    }
//    public int depth (TreeNode root) {
//        if (root == null)return 0;
//        int left = depth(root.left);
//        int right = depth(root.right);
//        return (left > right ? left : right) + 1;
//    }
//    public int recur(TreeNode root,int line) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int max = 0;
//        //标识上一行的最后一个节点。
//        TreeNode last = root;
//        //标识最后遍历到的一个节点。
//        TreeNode nlast = null;
//        int cur = 1;
//        int temp = 0;
//        while (!queue.isEmpty()) {
//            TreeNode t = queue.poll();
//            temp += t.val;
//            if (t.left != null) {
//                queue.add(t.left);
//                nlast = t.left;
//            }
//            if (t.right != null) {
//                queue.add(t.right);
//                nlast = t.right;
//            }
//
//            if (t == last) {
//                last = nlast;
//                if (line == cur) {
//                    max = Math.max(max, temp);
//                }
//                temp = 0;
//                cur ++;
//            }
//        }
//        return max;
//    }
}
