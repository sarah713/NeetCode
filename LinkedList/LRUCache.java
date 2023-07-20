package LinkedList;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> map;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == cap) {
            remove(tail.prev);
        }
        insert(new Node(key, val));
    }

    void insert(Node node) {
        // add it in the map
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}

class Node {
    int key, val;
    Node prev = null, next = null;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}