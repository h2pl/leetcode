package 数据结构.树.递归.路径;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 最小路径 {
    //其实找的是根节点到叶子节点的最小路径值
    public int minDepth(TreeNode root) {
        if (root == null)return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //如果左右子树有一个为空，只能取不为空的长度
        if (left == 0 || right == 0)return left + right + 1;
        //如果都不为空，则取小的那一个。妙啊
        return Math.min(left,right) + 1;

    }


}
