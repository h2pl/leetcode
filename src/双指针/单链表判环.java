package 双指针;
/**
 * Definition for singly-linked list.

 * }
 */
/**
 * Created by 周杰伦 on 2018/3/30.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class 单链表判环 {

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null)return false;
            if (head.next == head) return true;
            ListNode slow = head;
            ListNode fast = head;
            while (slow.next != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)return true;
            }
            return false;
        }
    }
}
