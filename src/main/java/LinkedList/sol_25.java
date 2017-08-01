package LinkedList;

import java.util.List;

/**
 * Created by Wang on 2017/6/22.
 */
public class sol_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || 1 == k) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevRev = dummy;
        ListNode trav = head;
        ListNode st, end, prev, cur, next;
        int count = 1;
        while (trav != null) {
            trav = trav.next;
            if (k == ++count && trav != null) {
                st = prevRev.next;
                end = trav.next;
                prev = null;
                cur = st;
                next = st.next;
                while (next != end) {
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                    next = next.next;
                }
                cur.next = prev;
                prevRev.next = cur;
                st.next = end;
                trav = st;
                prevRev = st;
                count = 0;
            }
        }


        return dummy.next;
    }
}
