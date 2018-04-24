package 数据结构.树.层次遍历;

import 数据结构.树.TreeNode;

import java.util.*;

/**
 * Created by 周杰伦 on 2018/4/24.
 */
public class 一棵树每层节点的平均数 {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        queue.add(root);
        //标识上一行的最后一个节点。
        TreeNode last = root;
        //标识最后遍历到的一个节点。
        TreeNode nlast = null;
        double temp = 0;
        double cnt= 0;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            temp += t.val;
            cnt ++;
            if (t.left != null) {
                queue.add(t.left);
                nlast = t.left;
            }
            if (t.right != null) {
                queue.add(t.right);
                nlast = t.right;
            }

            if (t == last) {
                last = nlast;
                list.add(temp/cnt);
                temp = 0;
                cnt = 0;
            }
        }
        return list;
    }
}
