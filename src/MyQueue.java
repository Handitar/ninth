
public class MyQueue {
    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public Object peek() {
        return (head != null) ? head.value : null;
    }

    public Object poll() {
        if (head == null) {
            return null;
        }

        Object value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return value;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}
