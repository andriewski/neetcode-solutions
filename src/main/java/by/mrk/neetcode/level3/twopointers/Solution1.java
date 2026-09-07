package by.mrk.neetcode.level3.twopointers;

/**
 * <a href="https://neetcode.io/problems/is-palindrome/question">Valid Palindrome</a>
 */
public class Solution1 {

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j;) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
