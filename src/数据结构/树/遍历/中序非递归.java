package 数据结构.树.遍历;

import 数据结构.树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 周杰伦 on 2018/4/25.
 */
public class 中序非递归 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        stack.push(p);
        //p.left代表新进栈的值，stack里的是原来待遍历的值，两边都为空时说明遍历结束。
        while (p.left != null || !stack.isEmpty()) {
            //先把左子树的节点进栈。
            while (p.left != null) {
                p = p.left;
                stack.push(p);
            }
            //左下角节点出栈并访问，如果他有右子树，右子树进栈，并且退出循环
            //进入第一个环节，将该右子树节点的所有左节点进栈，以此类推即可完成。
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                list.add(t.val);
                if (t.right != null) {
                    stack.push(t.right);
                    p = t.right;
                    break;
                }
            }
        }
        return list;
    }
}
