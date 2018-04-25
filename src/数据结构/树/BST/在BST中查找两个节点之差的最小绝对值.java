package 数据结构.树.BST;

import 数据结构.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/25.
 */
public class 在BST中查找两个节点之差的最小绝对值 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = inorder(root, new ArrayList<>());
        int min = Integer.MAX_VALUE;
        for (int i = 1;i < list.size();i ++) {
            if (Math.abs(list.get(i) - list.get(i - 1)) < min) {
                min = Math.abs(list.get(i) - list.get(i - 1));
            }
        }
        return min;
    }
    public List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
}
