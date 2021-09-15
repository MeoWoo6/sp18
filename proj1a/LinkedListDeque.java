/**
 * Deque (usually pronounced like “deck”) is an irregular acronym of double-ended queue.
 * Double-ended queues are sequence containers with dynamic sizes that can be expanded or contracted on both ends
 * (either its front or its back).
 * @param <T>
 */
public class LinkedListDeque<T> {
    /**
     * inner private class Node
     */
    private class Node {
        private Node prev;
        private Node next;
        private T item;
        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node((T) new Object(), null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    public void addFirst(T item) {
        Node first = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item
     */
    public void addLast(T item) {
        Node last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }else {
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
        for (Node node = sentinel.next; node != sentinel; node = node.next) {
            if (node.next == sentinel) {
                System.out.println(node.item);
                break;
            }
            System.out.print(node.item + " ");
        }
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size--;
            T removeItem = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            return removeItem;
        }
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size--;
            T removeItem = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            return removeItem;
        }
    }

    /**
     *  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    public T get(int index) {
        if (size < index) {
            return null;
        } else {
            int mid = size / 2;
            Node ptr = sentinel;
            if (index <= mid) {
                for (int i = 0; i <= index; i++) {
                    ptr = ptr.next;
                }
            } else {
                for (int i = size - 1; i >= index; i--) {
                    ptr = ptr.prev;
                }
            }
            return ptr.item;
        }
    }

    public T getRecursive(int index) {
        if (size < index) {
            return null;
        } else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursiveHelper(node.next, index-1);
        }
    }
}
