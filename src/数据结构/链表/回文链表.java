package 数据结构.链表;

import java.util.Stack;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 回文链表 {

    //对回文理解有偏差了。
    //以为只有1001 221122这种才是。
    //事实上101 10001 这种也是
//    public boolean isPalindrome(ListNode head) {
//        Stack<ListNode> stack = new Stack<>();
//        ListNode p = head;
//        if (head == null)return true;
//        if (head.next == null)return true;
//        while (p != null) {
//            if (p.next != null && (p.val != p.next.val ||p.next.next != null && p.val != p.next.next.val)){
//                stack.push(p);
//                p = p.next;
//                continue;
//            }
//            if (p.next == null) {
//                return false;
//            }else {
//                if (p.next.next != null && p.val == p.next.next.val) {
//                    p = p.next.next;
//                }else {
//                    p = p.next;
//                }
//                while (!stack.isEmpty() && p.next != null) {
//                    ListNode top = stack.pop();
//                    p = p.next;
//                    if (top.val != p.val) {
//                        return false;
//                    }
//                }
//                if (stack.isEmpty() && p.next == null) {
//                    return true;
//                }else {
//                    return false;
//                }
//            }
//        }
//        return false;
//    }
//
//    要求以 O(1) 的空间复杂度来求解。
//
//    切成两半，把后半段反转，然后比较两半是否相等。

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {  // 偶数节点，让 slow 指向下一个节点
            slow = slow.next;
        }

        cut(head, slow); // 切成两个链表
        ListNode l1 = head, l2 = slow;
        l2 = reverse(l2);
        return isEqual(l1, l2);
    }

    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) head = head.next;
        head.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }


}
