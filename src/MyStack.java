public class MyStack<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T peek() {
        return (top != null) ? top.value : null;
    }

    public T pop() {
        if (top == null) return null;

        T value = top.value;
        top = top.next;
        size--;

        return value;
    }

    public T remove(int index) {
        checkIndex(index);

        if (index == 0) return pop();

        Node<T> prev = getNode(index - 1);
        Node<T> toRemove = prev.next;

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

    private Node<T> getNode(int index) {
        Node<T> cur = top;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }
}