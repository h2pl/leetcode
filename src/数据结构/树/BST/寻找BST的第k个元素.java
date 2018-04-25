package 数据结构.树.BST;

import 数据结构.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/25.
 */
public class 寻找BST的第k个元素 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        List<Integer> list = inorder(root, new ArrayList<>());
        return list.get(k - 1);
    }

    public List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
}
