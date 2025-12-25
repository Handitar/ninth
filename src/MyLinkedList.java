
public class MyLinkedList {
    private static class Node {
        Object value;
        Node next;
        Node prev;

        Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public Object get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    public Object remove(int index) {
        checkIndex(index);

        Node node = getNode(index);
        Object removedValue = node.value;

        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }

        size--;
        return removedValue;
    }

    public void clear() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.prev = null;
            current.next = null;
            current.value = null;
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    //допоміжні метооди

    private Node getNode(int index) { // індекс ближче до head - ідемо зліва, а якщо ближче до tail - ідемо справа
        if (index < size / 2) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }
}
