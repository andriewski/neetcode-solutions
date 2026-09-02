package by.mrk.neetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://neetcode.io/problems/anagram-groups/question">Group Anagrams</a>
 */
public class Solution4 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return Collections.emptyList();
        } else if (strs.length == 1) {
            return List.of(List.of(strs));
        }

        Map<String, List<String>> countedWord2Anagrams = new LinkedHashMap<>(strs.length);

        for (String str : strs) {
            char[] counts = new char[26];

            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }

            List<String> anagrams = countedWord2Anagrams.computeIfAbsent(String.valueOf(counts), key -> new ArrayList<>());

            anagrams.add(str);
        }

        return new ArrayList<>(countedWord2Anagrams.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> sortedAnagram2Anagrams = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedAnagram = String.valueOf(chars);

            List<String> anagrams = sortedAnagram2Anagrams.computeIfAbsent(sortedAnagram, key -> new ArrayList<>());
            anagrams.add(str);
        }

        return new ArrayList<>(sortedAnagram2Anagrams.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<Map<Character, Integer>, List<String>> frequency2Anagrams = new LinkedHashMap<>(strs.length);

        for (String str : strs) {
            Map<Character, Integer> frequency = new HashMap<>(str.length());

            for (char letter : str.toCharArray()) {
                frequency.put(letter, frequency.getOrDefault(letter, 0) + 1);
            }

            List<String> anagrams = frequency2Anagrams.computeIfAbsent(frequency, key -> new ArrayList<>());
            anagrams.add(str);
        }

        return new ArrayList<>(frequency2Anagrams.values());
    }
}
