public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        char[] words = word.toCharArray();
        LinkedListDeque<Character> wordlist = new LinkedListDeque<>();
        for (char letter : words) {
            wordlist.addLast(letter);
        }
        return wordlist;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> words = wordToDeque(word);
        return isPalindromeHelper(words);
    }

    private boolean isPalindromeHelper(Deque<Character> words) {
        if (words.size() == 0 || words.size() == 1) {
            return true;
        } else {
            return (words.removeFirst() == words.removeLast() && isPalindromeHelper(words));
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> words = wordToDeque(word);
        return isPalindromeHelper(words, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> words, CharacterComparator cc) {
        if (words.size() == 0 || words.size() == 1) {
            return true;
        } else {
            return (cc.equalChars(words.removeFirst(), words.removeLast()) && isPalindromeHelper(words, cc));
        }
    }
}
