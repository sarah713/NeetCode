package LinkedList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
