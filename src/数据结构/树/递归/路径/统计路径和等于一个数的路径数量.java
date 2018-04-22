package 数据结构.树.递归.路径;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 统计路径和等于一个数的路径数量 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        t2.right = t3;
        t1.left = t2;
        t1.right = t4;
        System.out.println(pathSum(t1, 6));
    }
    //从树中任意一点出发，找到一段路径和为sum即可。
    public static int pathSum(TreeNode root, int sum) {
        if (root == null)return 0;
        int cnt = count(root, sum);
        cnt += pathSum(root.left, sum);
        cnt += pathSum(root.right, sum);
        return cnt;
    }

    //从该节点往下寻找，满足条件即可以++
    public static int count(TreeNode root, int sum) {
        if (root == null) return 0;
        int cnt = 0;
        if (root.val == sum) cnt ++;
        cnt += count(root.left, sum - root.val);
        cnt += count(root.right, sum - root.val);
        return cnt;
    }
}
