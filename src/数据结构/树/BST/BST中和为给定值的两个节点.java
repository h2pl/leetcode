package 数据结构.树.BST;

import 数据结构.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/25.
 */
public class BST中和为给定值的两个节点 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)return false;
        List<Integer> list = inorder(root, new ArrayList<>());
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) + list.get(right) > k) {
                right --;
            }else if(list.get(left) + list.get(right) < k) {
                left ++;
            }else return true;
        }
        return false;
    }
    public List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
}
