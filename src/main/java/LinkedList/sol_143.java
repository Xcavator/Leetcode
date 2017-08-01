package LinkedList;
import java.util.*;

/**
 * Reorder List
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
 reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * Created by Wang on 2017/6/21.
 */
public class sol_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        // two pointer
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse right half
        // LinkedList.ListNode dummy = slow;
        ListNode prev = null;
        ListNode cur = slow.next;
        ListNode next = slow.next.next;
        slow.next = null;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;

        }
        cur.next = prev;
        // add
        ListNode h2 = cur;
        cur = head;
        next = h2.next;
        while (next != null)  {
            h2.next = cur.next;
            cur.next = h2;
            cur = h2.next;
            h2 = next;
            next = next.next;
        }
        h2.next = cur.next;
        cur.next = h2;
    }
}
