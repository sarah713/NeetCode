package LinkedList;

public class Merge2SortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tmp.next = new ListNode(list1.val);
                list1 = list1.next;
                tmp = tmp.next;
            } else {
                tmp.next = new ListNode(list2.val);
                list2 = list2.next;
                tmp = tmp.next;
            }
        }
        while (list1 != null) {
            tmp.next = new ListNode(list1.val);
            list1 = list1.next;
            tmp = tmp.next;
        }
        while (list2 != null) {
            tmp.next = new ListNode(list2.val);
            list2 = list2.next;
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
