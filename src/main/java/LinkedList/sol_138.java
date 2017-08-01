package LinkedList;

/**
 * Created by Wang on 2017/6/22.
 */
public class sol_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (null == head) return null;

        // intuitive idea: hash
        RandomListNode curptr = head;
        while (curptr != null) {
            RandomListNode copy = new RandomListNode(curptr.label);
            copy.next = curptr.next;
            copy.random = curptr.random;
            curptr.next = copy;
            curptr = copy.next;
        }
        curptr = head;
        while (curptr != null) {
            if (null != curptr.random)
                curptr.next.random = curptr.random.next;
            curptr = curptr.next.next;
        }

        RandomListNode newHead = new RandomListNode(0);
        RandomListNode prevptr = head;
        curptr = newHead;

        while (null != prevptr) {
            curptr.next = prevptr.next;
            curptr = curptr.next;
            prevptr.next = curptr.next;
            prevptr = prevptr.next;
        }
        return newHead.next;
    }
}
