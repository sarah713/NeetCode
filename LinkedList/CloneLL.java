package LinkedList;

public class CloneLL {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node tmp = head;
        // clone the nodes
        while (tmp != null) {
            Node next = tmp.next;
            Node copy = new Node(tmp.val);
            tmp.next = copy;
            copy.next = next;
            tmp = next;
        }

        tmp = head;
        // assign copy pointers
        Node next = head;
        while (tmp != null) {
            next = tmp.next.next;
            Node copy = tmp.next;
            if (tmp.random != null) {
                copy.random = tmp.random.next;
            }
            tmp = next;
        }

        // restore original list
        tmp = head;
        Node pseudo = new Node(0);
        Node copy, copyIter = pseudo;
        while (tmp != null) {
            next = tmp.next.next;
            copy = tmp.next;
            copyIter.next = copy;
            copyIter = copy;
            tmp.next = next;
            tmp = next;
        }
        return pseudo;

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}