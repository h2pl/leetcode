package 数据结构.链表;

import ADT.TreeNode;

/**
 * Created by 周杰伦 on 2018/4/19.
 */
public class 根据有序链表构造平衡的BST {
    //先找到中点作为根节点，递归找中点左右链表的中点，作为左右子树。
    //难点在于边界判断，这个不是我写的。
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int size = size(head);
        if (size == 1) return new TreeNode(head.val);
        ListNode pre = head, mid = pre.next;
        int step = 2;
        while (step <= size / 2) {
            pre = mid;
            mid = mid.next;
            step++;
        }
        pre.next = null;
        TreeNode t = new TreeNode(mid.val);
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);
        return t;
    }
    private int size(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
//    public TreeNode sortedListToBST(ListNode head) {
//        int cnt = 0;
//        ListNode p = head;
//        while (p != null) {
//            p = p.next;
//            cnt ++;
//        }
//        return setTree(head, 0, cnt);
//    }
//    public TreeNode setTree(ListNode l,int start,int end) {
//        int index = (end - start)/2;
//        ListNode p = l;
//        ListNode pre = p;
//        for (int i = 1;i <= index && p.next != null;i ++) {
//            p = p.next;
//            pre = p;
//        }
//
//        TreeNode t = new TreeNode(p.val);
//        if (p.next != null) {
//            t.right = setTree(l,index + 1, end);
//        }
//        t.left = setTree(l,start,index - 1);
//        return t;
//    }
}
