package 数据结构.树.BST;

import 数据结构.树.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 从有序数组中构造二叉查找树 {
//    Leetcode : 108. Convert Sorted Array to Binary Search Tree (Easy)

    //很有难度啊，必须知道二叉查找树可以用二分法来构造子树，每个中点都是一个根节点。
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    //根据节点的位置关系进行递归
    private TreeNode toBST(int[] nums, int sIdx, int eIdx){
        if(sIdx > eIdx) return null;
        int mIdx = (sIdx + eIdx) / 2;
        TreeNode root = new TreeNode(nums[mIdx]);
        root.left =  toBST(nums, sIdx, mIdx - 1);
        root.right = toBST(nums, mIdx + 1, eIdx);
        return root;
    }
}
