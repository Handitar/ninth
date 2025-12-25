
public class MyHashMap {
    private static class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    private int index(Object key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(Object key, Object value) {
        int index = index(key);
        Node current = table[index];

        // Якщо ключ вже існує — оновлюємо значення
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    public Object get(Object key) {
        int index = index(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(Object key) {
        int index = index(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }
}
