package 数据结构.链表;

/**
 * Created by 周杰伦 on 2018/4/19.
 */
public class 归并两个有序的链表 {

//    链表和树一样，可以用递归方式来定义：链表是空节点，或者有一个值和一个指向下一个链表的指针。因此很多链表问题可以用递归来处理。
//    妙哉妙哉
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode newHead = null;
        if(l1.val < l2.val){
            newHead = l1;
            newHead.next = mergeTwoLists2(l1.next, l2);
        } else{
            newHead = l2;
            newHead.next = mergeTwoLists2(l1, l2.next);
        }
        return newHead;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l2.next = l3;
        l1.next = l2;

        l5.next = l6;
        l4.next = l5;

        System.out.println(mergeTwoLists(l1,l4));
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)return l2;
        if (l2 == null)return l1;
        ListNode p = l1;
        ListNode q = l2;
        ListNode h = new ListNode(0);
        ListNode op = h;
        while (p != null && q != null) {
            if (p.val < q.val) {
                op.next = new ListNode(p.val);
                p = p.next;
                op = op.next;
            }else if (p.val > q.val) {
                op.next = new ListNode(q.val);
                q = q.next;
                op = op.next;
            }else {
                op.next = new ListNode(p.val);
                op = op.next;
                op.next = new ListNode(q.val);
                op = op.next;
                p = p.next;
                q = q.next;
            }
        }
        while (p != null) {
            op.next = new ListNode(p.val);
            p = p.next;
            op = op.next;
        }
        while (q != null) {
            op.next = new ListNode(q.val);
            q = q.next;
            op = op.next;
        }
        op.next = null;
        return h.next;
    }
}
