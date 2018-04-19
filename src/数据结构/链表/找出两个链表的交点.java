package 数据结构.链表;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 找出两个链表的交点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        int len = len1 - len2;
        //长的
        ListNode p = len >= 0 ? headA : headB;
        //短的
        ListNode q = len >= 0 ? headB : headA;
        len = Math.abs(len);
        while (len > 0) {
            p = p.next;
            len --;
        }
        while (p != q && p != null && q != null) {
            p = p.next;
            q = q.next;
        }

        return p;
    }

    public int getLength(ListNode node) {
        int cnt = 0;
        while (node != null) {
            node = node.next;
            cnt ++;
        }
        return cnt;
    }

}
