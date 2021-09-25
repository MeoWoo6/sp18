public class OffByN implements CharacterComparator{
    private int Diff;
    public OffByN(int N) {
        Diff = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == Diff || y - x == Diff) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OffByN offBy5 = new OffByN(5);
        System.out.println(offBy5.equalChars('a', 'f')); //true
        System.out.println(offBy5.equalChars('f', 'a')); //true
        System.out.println(offBy5.equalChars('f', 'h')); //false
    }
}
