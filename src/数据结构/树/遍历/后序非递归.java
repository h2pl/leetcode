package 数据结构.树.遍历;

import 数据结构.树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 周杰伦 on 2018/4/25.
 */
public class 后序非递归 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        recur(stack, root);
        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
        }
        return list;
    }

    public void recur (Stack<TreeNode> stack, TreeNode root) {
        if (root == null) return;
        stack.push(root);
        recur(stack, root.right);
        recur(stack, root.left);
        return;
    }
}
