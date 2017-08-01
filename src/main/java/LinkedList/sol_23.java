package LinkedList;

/**
 * Created by Wang on 2017/6/24.
 */
public class sol_23 {
    int size;
    ListNode[] min_heap;
    public ListNode mergeKLists(ListNode[] lists) {
        size = lists.length;
        min_heap = new ListNode[size + 1];
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (int i = 0; i < size; ++i)
            min_heap[i + 1] = lists[i];
        buildHeap();
        while (size > 0) {
            cur.next = min_heap[1];
            cur = cur.next;
            min_heap[1] = min_heap[1].next;
            if (min_heap[1] == null) {
                min_heap[1] = min_heap[size--];
            }
            percolatingDown(1);
        }
        return dummy.next;
    }

    void buildHeap() {
        for (int i = size / 2; i > 0; --i)
            percolatingDown(i);
    }
    void percolatingDown(int k) {
        ListNode tmp = min_heap[k];
        int child;
        for (; 2 * k <= size; k = child) {
            child = 2 * k;
            if (child != size
                && min_heap[child].val > min_heap[child + 1].val)
                child++;
            if (tmp.val < min_heap[child].val) {
                break;
            } else {
                min_heap[k] = min_heap[child];
            }
        }
        min_heap[k] = tmp;
    }

}
