package 数据结构.树;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 最小路径 {
    //其实找的是最小深度
    public int minDepth(TreeNode root) {
        if (root == null)return 0;
        if (root.left == null && root.right == null)return 1;
        return 0;

    }


}
