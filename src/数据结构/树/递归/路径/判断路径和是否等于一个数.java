package 数据结构.树.递归.路径;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 判断路径和是否等于一个数 {
    //本题有个坑。空树一定返回false。所以要判断左右子树为空并且val = sum。
    //而不能直接判断sum = 0 && root = null
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum)return true;
        sum -= root.val;
        boolean left = hasPathSum(root.left, sum);
        boolean right = hasPathSum(root.right, sum);
        return left || right;
    }
}
