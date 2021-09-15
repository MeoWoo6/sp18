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
        A.addLast(0);
        A.addFirst(1);
        A.removeLast();
        A.addLast(3);
        A.addLast(4);
        A.addLast(5);
        A.addLast(6);
        A.removeFirst();
        A.addFirst(8);
        A.addFirst(9);
        A.addLast(10);
        A.get(2);
        A.addFirst(12);
        A.get(2);
        return true;
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
        boolean passed;
        A.addFirst(1);
        A.addFirst(0);
        A.addLast(2);
        A.addLast(3);
        passed = (A.removeFirst() == 0);
        passed = passed && (A.removeFirst() == 1);
        passed = passed && (A.removeLast() == 3);
        return passed;
    }

    /**
     * check resize method, when resize, addLast is different with addFirst
     * be careful with the index
     * @return
     */
    public static boolean resizeTest() {
        System.out.println("Running the most tricky part -- Resize the Deque Array");
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(0);
        A.addLast(1);
        A.addLast(2);
        A.addFirst(3);
        A.addLast(4);
        A.addLast(5);
        A.addFirst(6);
        A.addFirst(7);
        A.addLast(8);
        boolean passed;
        passed = (A.getCapacity() == 16);
        passed = passed && (A.removeLast() == 8);
        A.removeLast();
        A.removeLast();
        A.removeFirst();
        passed = passed && (A.removeLast() == 2);
        passed = passed && (A.getCapacity() == 16);
        A.removeLast();
        passed = passed && (A.getCapacity() == 8);
        passed = passed && (A.removeFirst() == 6);
        A.removeLast();
        A.removeLast();
        passed = passed && (A.getCapacity() == 8) && (A.isEmpty());
        passed = passed && (A.removeLast() == null);
        passed = passed && (A.size() == 0);
        return passed;
    }

    /**
     * fill up, empty, fill up again
     * @return
     */
    public static boolean backtoemptyTest1() {
        boolean passed;
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(0);
        A.addFirst(1);
        A.addFirst(2);
        A.addFirst(3);
        A.addFirst(4);
        A.addFirst(5);
        A.addFirst(6);
        A.addFirst(7);
        passed = A.removeFirst() == 7;
        passed = passed && (A.removeFirst() == 6);
        passed = passed && (A.removeFirst() == 5);
        passed = passed && (A.removeFirst() == 4);
        passed = passed && (A.removeFirst() == 3);
        passed = passed && (A.removeFirst() == 2);
        passed = passed && (A.removeFirst() == 1);
        passed = passed && (A.removeFirst() == 0);
        A.addFirst(0);
        A.addFirst(1);
        A.addFirst(2);
        A.addFirst(3);
        A.addFirst(4);
        A.addFirst(5);
        A.addFirst(6);
        A.addFirst(7);
        passed = passed && (A.removeFirst() == 7);
        return passed;
    }

    public static boolean backtoemptyTest2() {
        boolean passed;
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addLast(0);
        A.addLast(1);
        A.addLast(2);
        A.addLast(3);
        A.addLast(4);
        A.addLast(5);
        A.addLast(6);
        A.addLast(7);
        passed = A.removeLast() == 7;
        passed = passed && (A.removeLast() == 6);
        passed = passed && (A.removeLast() == 5);
        passed = passed && (A.removeLast() == 4);
        passed = passed && (A.removeLast() == 3);
        passed = passed && (A.removeLast() == 2);
        passed = passed && (A.removeLast() == 1);
        passed = passed && (A.removeLast() == 0);
        A.addLast(0);
        A.addLast(1);
        A.addLast(2);
        A.addLast(3);
        A.addLast(4);
        A.addLast(5);
        A.addLast(6);
        A.addLast(7);
        passed = passed && (A.removeLast() == 7);
        passed = passed && (A.removeLast() == 6);
        return passed;
    }

    public static boolean backtoemptyTest3() {
        boolean passed;
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(0);
        A.addLast(1);
        A.addFirst(2);
        A.addLast(3);
        A.addFirst(4);
        A.addLast(5);
        A.addFirst(6);
        A.addLast(7);
        passed = A.removeLast() == 7;
        passed = passed && (A.removeLast() == 5);
        passed = passed && (A.removeLast() == 3);
        passed = passed && (A.removeLast() == 1);
        passed = passed && (A.removeLast() == 0);
        passed = passed && (A.removeLast() == 2);
        passed = passed && (A.removeLast() == 4);
        passed = passed && (A.removeLast() == 6);
        A.addLast(0);
        A.addFirst(1);
        A.addLast(2);
        A.addFirst(3);
        A.addLast(4);
        A.addFirst(5);
        A.addLast(6);
        A.addFirst(7);
        passed = passed && (A.removeFirst() == 7);
        passed = passed && (A.removeFirst() == 5);
        return passed;
    }
    public static void main(String[] args) {
//        printTestStatus(addAndgetTest());
//        printTestStatus(removeTest());
//        printTestStatus(sizeAndemptyTest());
//        printTestStatus(resizeTest());
//        printTestStatus(backtoemptyTest1());
//        printTestStatus(backtoemptyTest2());
        printTestStatus(backtoemptyTest3());
    }
}
