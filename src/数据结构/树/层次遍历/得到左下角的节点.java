package 数据结构.树.层次遍历;

import 数据结构.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 周杰伦 on 2018/4/24.
 */
public class 得到左下角的节点 {
    //其实就是层次遍历的最后一个节点。
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }

    //傻逼了，这样做复杂化了。
//    public int findBottomLeftValue(TreeNode root) {
//        if (root == null) return 0;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        int depth = depth(root);
//        int line = 1;
//        queue.add(root);
//        //标识上一行的最后一个节点。
//        TreeNode last = root;
//        //标识最后遍历到的一个节点。
//        TreeNode nlast = null;
//        while (!queue.isEmpty()) {
//            TreeNode t = queue.poll();
//            if (line == depth) {
//                return t.val;
//            }
//            if (t.left != null) {
//                queue.add(t.left);
//                nlast = t.left;
//            }
//            if (t.right != null) {
//                queue.add(t.right);
//                nlast = t.right;
//            }
//
//            if (t == last ) {
//                last = nlast;
//                line ++;
//            }
//        }
//        return root.val;
//    }
//
//    public int depth (TreeNode root) {
//        if (root == null)return 0;
//        int left = depth(root.left);
//        int right = depth(root.right);
//        return (left > right ? left : right) + 1;
//    }

}
