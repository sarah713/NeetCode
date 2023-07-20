package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLL {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            tmp.next = cur;
            tmp = tmp.next;

            if (cur.next != null) {
                heap.offer(cur.next);
            }

        }
        return dummy.next;
    }
}
