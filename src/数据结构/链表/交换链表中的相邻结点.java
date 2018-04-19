package 数据结构.链表;

/**
 * Created by 周杰伦 on 2018/4/19.
 */
public class 交换链表中的相邻结点 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        System.out.println(swapPairs(l1));
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        ListNode p = h;
        ListNode l = head;
        ListNode r = head.next;
        while (l != null && r != null) {
            ListNode temp = r.next;
            r.next = l;
            h.next = r;
            h = h.next.next;
            l = temp;
            if (l != null && l.next != null) {
                r = l.next;
            }else {
                h.next = l;
                return p.next;
            }
        }
        return p.next;
    }
}
