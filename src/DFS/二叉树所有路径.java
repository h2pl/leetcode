package DFS;

import ADT.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/3/31.
 */
public class 二叉树所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null)return list;
        String str = "";
        return dfs(root, list, str);
    }
    public List<String> dfs (TreeNode root, List<String> list, String str) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            str += root.val;
        }else {
            str += root.val + "->";
        }

        dfs(root.left, list, str);
        dfs(root.right, list, str);
        if (root.left == null && root.right == null) {
            list.add(str);
        }
        str = "";
        return list;
    }
}
