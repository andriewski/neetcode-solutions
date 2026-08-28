package by.mrk.neetcode.level1.arrays.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://neetcode.io/problems/is-anagram/question">Valid Anagram</a>
 */
public class Solution2 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.isEmpty()) {
            return false;
        }

        if (s.length() == 1) {
            return s.equals(t);
        }

        Map<Character, Integer> sFrequency = new HashMap<>();
        Map<Character, Integer> tFrequency = new HashMap<>();

        for (char c : t.toCharArray()) {
            sFrequency.put(c, sFrequency.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            tFrequency.put(c, tFrequency.getOrDefault(c, 0) + 1);
        }

        return sFrequency.equals(tFrequency);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length() || s.isEmpty()) {
            return false;
        }

        if (s.length() == 1) {
            return s.equals(t);
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length() || s.isEmpty()) {
            return false;
        }

        if (s.length() == 1) {
            return s.equals(t);
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return String.valueOf(sArray).equals(String.valueOf(tArray));
    }
}
