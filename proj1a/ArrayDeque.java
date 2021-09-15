/**
 * @author Meo
 * @param <T>
 */
public class ArrayDeque<T> {

    private int capacity;
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] arraydeque;

    /**
     * Constructor
     */
    public ArrayDeque() {
        size = 0;
        capacity = 8;
        nextFirst = 0;
        nextLast = 1;
        arraydeque = (T[]) new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    public void addFirst(T item) {
        arraydeque[nextFirst] = item;
        size++;
        if (size == capacity) {
            resize(capacity * 2, nextFirst);
        } else {
            nextFirst = (nextFirst + capacity - 1) % capacity;
        }
    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item
     */
    public void addLast(T item) {
        arraydeque[nextLast] = item;
        size++;
        if (size == capacity) {
            resize(capacity * 2, (nextFirst + 1) % capacity);
        } else {
            nextLast = (nextLast + 1) % capacity;
        }
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of items in the deque.
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        int index = (nextFirst + 1) % capacity;
        for (int i = 0; i < size; i++) {
            System.out.print(arraydeque[index] + " ");
            index = (index + 1) % capacity;
        }
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = arraydeque[(nextFirst + 1) % capacity];
        size--;
        nextFirst = (nextFirst + 1) % capacity;
        if (4 * size < capacity && capacity >= 16) {
            resize(capacity / 2, (nextFirst + 1) % capacity);
        }
        return item;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = arraydeque[(nextLast - 1 + capacity) % capacity];
        size--;
        if (4 * size < capacity && capacity >= 16) {
            resize(capacity / 2, (nextFirst + 1) % capacity);
        } else {
            nextLast = (nextLast - 1 + capacity) % capacity;
        }
        return item;
    }

    /**
     *  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!
     *  Be aware that the given parameter index is not the "real" index in the ArrayDeque!
     * @param index
     * @return
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int ptr = (nextFirst + index + 1) % capacity;
        return arraydeque[ptr];
    }

    private void resize(int capacity, int firstIndex) {
        T[] resizeArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            resizeArray[i] = arraydeque[firstIndex];
            firstIndex = (firstIndex + 1) % this.capacity;
        }
        this.capacity = capacity;
        nextFirst = capacity - 1;
        nextLast = size;
        arraydeque = resizeArray;
    }
}
