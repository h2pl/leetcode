package 数据结构.树.递归.树的操作;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 *
        3
      / \
    4   5
   / \
 1   2

    4
  / \
1   2
 */
public class 子树 {
    //判断是非问题时，先把不满足的情况找出来。再把需要满足的情况找出来。最后返回递归
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)return false;
        if (recur(s,t))return true;
        if (isSubtree(s.left,t)) return true;
        if (isSubtree(s.right,t)) return true;
        return false;
    }

    public boolean recur (TreeNode s, TreeNode t) {
        if (s == null && t == null)return true;
        if (s == null || t == null)return false;
        if (s.val != t.val)return false;
        return recur(s.left, t.left) && recur(s.right, t.right);
    }

}
