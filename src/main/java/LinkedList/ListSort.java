package LinkedList;

/**
 * Created by Wang on 2017/6/22.
 */
public class ListSort {
    ListNode mergeSort(ListNode head) {
        if (null == head || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (null != fast && null != fast.next) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return merge(mergeSort(head), mergeSort(slow));
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode head, cur, ptr1, ptr2;
        if (l1.val < l2.val) {
            head = l1;
            cur = l1;
            ptr1 = l1.next;
            ptr2 = l2;
        } else {
            head = l2;
            cur = l2;
            ptr1 = l1;
            ptr2 = l2.next;
        }
        while (null != ptr1 && null != ptr2) {
            if (ptr1.val < ptr2.val) {
                cur.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                cur.next = ptr2;
                ptr2 = ptr2.next;
            }
            cur = cur.next;
        }
        if (null != ptr1) cur.next = ptr1;
        if (null != ptr2) cur.next = ptr2;

        return head;
    }

//    ListNode bucketSort(ListNode head) {
//
//    }

    ListNode qSort(ListNode head) {
        if(head == null|| head.next == null) return head;

        ListNode ehandle = new ListNode(0), equal = ehandle;
        ListNode lhandle = new ListNode(0), left = lhandle;
        ListNode rhandle = new ListNode(0), right = rhandle;

        ListNode current = head;
        while(current != null){

            if(current.val < head.val){
                left.next = current;
                left = left.next;
            }

            else if(current.val == head.val){
                equal.next = current;
                equal = equal.next;
            }

            else{
                right.next = current;
                right = right.next;
            }

            current = current.next;
        }
        left.next = equal.next = right.next = null;


        ListNode small = qSort(lhandle.next);
        ListNode large = qSort(rhandle.next);

        equal.next = large;
        if(small == null) return ehandle.next;

        ListNode tail = small;
        while(tail.next != null) tail = tail.next;
        tail.next = ehandle.next;

        return small;
    }

}
