package 数据结构.树.BST;

import 数据结构.树.TreeNode;

import java.util.*;

/**
 * Created by 周杰伦 on 2018/4/25.
 */
public class 寻找BST中出现次数最多的节点 {
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        List<Integer> list = inorder(root, new ArrayList<>());
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                max = Math.max(max,map.get(i));
            }else {
                map.put(i,1);
                max = Math.max(max,map.get(i));
            }
        }
        Set<Integer> set = map.keySet();
        for (int i : set) {
            if (map.get(i) == max) {
                res.add(i);
            }
        }
        int []arr = new int[res.size()];
        int index = 0;
        for (int i : res) {
            arr[index ++] = i;
        }
        return arr;
    }
    public List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
}
