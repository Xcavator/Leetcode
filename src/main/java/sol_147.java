import LinkedList.ListNode;

///**
// * Created by Wang on 2017/4/1.
// */
///**
// * Definition for singly-linked list.
// * public class LinkedList.ListNode {
// *     int val;
// *     LinkedList.ListNode next;
// *     LinkedList.ListNode(int x) { val = x; }
// * }
// */
public class sol_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode res_head = head;
        if (res_head == null || res_head.next == null)
            return res_head;
        ListNode cur = res_head.next;
        ListNode prev = res_head;

        while (null != cur) {
            if (cur.val < res_head.val) {
                prev.next = cur.next;
                cur.next = res_head;
                res_head = cur;
                cur = prev.next;

            } else {
                ListNode insert_pos = res_head;
                while (insert_pos.next != null && insert_pos.next != cur && insert_pos.next.val < cur.val) {
                    insert_pos = insert_pos.next;
                }
                if(insert_pos.next != cur) {
                    prev.next = cur.next;
                    cur.next = insert_pos.next;
                    insert_pos.next = cur;
                    cur = prev.next;
                } else {
                    prev = cur;
                    cur = cur.next;
                }

            }

        }
        return res_head;
    }
}