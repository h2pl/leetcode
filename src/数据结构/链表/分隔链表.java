package 数据结构.链表;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 分隔链表 {
    //多个节点串联的链表如何解决修改问题，修改节点的next会导致丢失后面的节点。
    //上面这个问题虽然解决了，但是除法得到余数的分段方式没想出来。
//    public ListNode[] splitListToParts(ListNode root, int k) {
//        ListNode []arr = new ListNode[k];
//        int size = size(root);
//        if (size <= k) {
//            int i = 0;
//            //每格只装一个，其余用null填补
//            ListNode l = root;
//            while (l != null) {
//                arr[i ++] = new ListNode(l.val);
//                l = l.next;
//            }
//            return arr;
//        }
//        int len = size/k;
//        int rem = size - len * k;
//        //这部分操作不知道怎么进行了
//        if (rem == 0) {
//            //每部分都一样长。
//            int i = 0;
//            //每格装len个
//            ListNode l = root;
//            ListNode next = l;
//            while (i < k && next != null) {
//                ListNode node = next;
//                l = node;
//                int cnt = 1;
//
//                while (cnt < len) {
//                    l = l.next;
//                    cnt ++;
//                }
//                next = l.next;
//                l.next = null;
//                arr[i ++] = node;
//            }
//        }else {
//            //有一部分多出来长度。
//            int i = 0;
//            //第一格装len + 1个，其他每格装len个
//            ListNode l = root;
//            ListNode next = l;
//            ListNode node = l;
//            int firstlen = 1;
//            while (firstlen < len + 1) {
//                l = l.next;
//                firstlen ++;
//            }
//            next = l.next;
//            l.next = null;
//            arr[i ++] = node;
//            //除了第一格
//
//            while (i < k && next != null) {
//                node = next;
//                l = node;
//                int cnt = 1;
//
//                while (cnt < len) {
//                    l = l.next;
//                    cnt ++;
//                }
//                next = l.next;
//                l.next = null;
//                arr[i ++] = node;
//            }
//        }
//        return arr;
//    }
//    public int size(ListNode node) {
//        int len = 0;
//        while (node != null) {
//            len ++;
//            node = node.next;
//        }
//        return len;
//    }

//    题目描述：把链表分隔成 k 部分，每部分的长度都应该尽可能相同，排在前面的长度应该大于等于后面的。

    public ListNode[] splitListToParts(ListNode root, int k) {
        int N = 0;
        ListNode cur = root;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        int mod = N % k;
        int size = N / k;
        ListNode[] ret = new ListNode[k];
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            ret[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ret;
    }
}
