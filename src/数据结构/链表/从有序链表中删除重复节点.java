package 数据结构.链表;

/**
 * Created by 周杰伦 on 2018/4/19.
 */
public class 从有序链表中删除重复节点 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode h = head;
        while (h.next != null) {
            if (h.val == h.next.val) {
                h.next = h.next.next;
            }else {
                h = h.next;
            }
        }
        return head;
    }
}
