package LinkedList;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        while (second != null) {
            st.push(second);
            second = second.next;
        }
        ListNode cur = head;
        while (!st.isEmpty() && cur != null) {
            ListNode next = cur.next;
            cur.next = new ListNode(st.pop().val);
            cur.next.next = next;
            cur = next;
        }
    }
}
