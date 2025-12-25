
public class MyStack {
    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }
    private Node top;
    private int size;

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Object peek() {
        return (top != null) ? top.value : null;
    }

    public Object pop() {
        if (top == null) {
            return null;
        }

        Object value = top.value;
        top = top.next;
        size--;

        return value;
    }

    public Object remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return pop();
        }

        Node prev = getNode(index - 1);
        Node toRemove = prev.next;

        prev.next = toRemove.next;
        size--;

        return toRemove.value;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    //допоміжні методи

    private Node getNode(int index) {
        Node current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }
}