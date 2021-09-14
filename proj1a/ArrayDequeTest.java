public class ArrayDequeTest {

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /**
     * check addFirst, addLast and get methods.
     * @return
     */
    public static boolean addAndgetTest() {
        System.out.println("Running addFirst, addLast and get index test.");
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.addFirst(0);
        A.addLast(2);
        A.addLast(3);
        boolean passed = true;
        passed = passed && (A.get(1) == 1) && (A.get(2) == 2);
        return passed;
    }
    /**
     * check size() and isEmpty()
     * @return
     */
    public static boolean sizeAndemptyTest() {
        System.out.println("Running size and isEmpty test.");
        ArrayDeque<Integer> A = new ArrayDeque<>();
        boolean passed = true;
        passed = passed && (A.size() == 0) && (A.isEmpty());
        A.addFirst(1);
        A.addFirst(0);
        A.removeFirst();
        passed = passed && (A.size() == 1) && (!A.isEmpty());
        return passed;
    }

    /**
     * check removeFirst and removeLast
     * @return
     */
    public static boolean removeTest() {
        System.out.println("Running remove first and remove last test.");
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.addFirst(0);
        A.addLast(2);
        A.addLast(3);
        A.removeFirst();
        A.removeFirst();
        A.removeLast();
        boolean passed = true;
        passed = passed && (A.get(0) == 2) && (A.get(2) == null);
        A.removeFirst();
        passed = passed && (A.isEmpty());
        A.addFirst(1);
        passed = passed && (A.get(0) == 1);
        return passed;
    }

    /**
     * check resize method
     * @return
     */
    public static boolean resizeTest() {
        System.out.println("Running the most tricky part -- Resize the Deque Array");
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(0);
        A.addLast(1);
        A.addLast(2);
        A.addLast(3);
        A.addLast(4);
        A.addLast(5);
        A.addLast(6);
        A.addLast(7);
        A.addLast(8);
        boolean passed;
        passed = (A.getCapacity() == 16);
        A.removeLast();
        A.removeLast();
        A.removeLast();
        A.removeLast();
        A.removeLast();
        passed = passed && (A.getCapacity() == 16);
        A.removeLast();
        passed = passed && (A.getCapacity() == 8);
        A.removeLast();
        A.removeLast();
        A.removeLast();
        passed = passed && (A.getCapacity() == 8);
        return passed;
    }

    /**
     * if the data structure goes from empty,
     * to some non-zero size (e.g. 4 items) back down to zero again
     * @return
     */
    public static boolean backtoemptyTest() {
        boolean passed;
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(0);
        A.addLast(1);
        A.addLast(2);
        A.addFirst(3);
        A.removeLast();
        A.removeLast();
        A.removeLast();
        A.removeLast();
        A.addLast(1);
        A.addLast(2);
        passed = A.get(1) == 2;
        return passed;
    }

    public static void main(String[] args) {
        printTestStatus(addAndgetTest());
        printTestStatus(removeTest());
        printTestStatus(sizeAndemptyTest());
        printTestStatus(resizeTest());
        printTestStatus(backtoemptyTest());
    }
}
