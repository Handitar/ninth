
public class MyArrayList {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }

    public void add(Object value) {
        ensureCapacity();
        data[size++] = value;
    }

    public Object remove(int index) {
        checkIndex(index);
        Object removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return removed;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        checkIndex(index);
        return data[index];
    }

    //допоміжні метооди

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }
}