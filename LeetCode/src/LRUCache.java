import java.util.*;

public class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (cache.get(key) == null) {
            return -1;
        }

        removeNode(node);
        offerNode(node);
        return node.value;
    }

    private void offerNode(Node node) {
        if (tail != null) {
            tail.next = node;
        }
        node.prev = tail;
        node.next = null;
        tail = node;

        if (head == null) {
            head = tail;
        }

    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

    }

    public void display() {
        for (Integer key : cache.keySet()) {
            System.out.println("Key :::" + cache.get(key).key +" Value : "+ cache.get(key).value);
        }
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            offerNode(node);

        } else {
            if (cache.size() >= capacity) {
                cache.remove(head.key);
                removeNode(head);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            offerNode(node);

        }
    }


    public static void main(String[] args) {
        LRUCache ca = new LRUCache(4);
        ca.put(1,1);
        ca.put(2,2);
        ca.put(3,3);
        ca.get(1);
        ca.put(4,4);
        ca.put(5,5);
        ca.display();
    }

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
