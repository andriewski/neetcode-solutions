package by.mrk.neetcode.level1.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://neetcode.io/problems/string-encode-and-decode/question">Encode and Decode Strings</a>
 */
public class Solution6 {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length())
                    .append("#")
                    .append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; ) {
            StringBuilder word = new StringBuilder();

            StringBuilder numberOfCharsToReadAsString = new StringBuilder();

            while (Character.isDigit(chars[i])) {
                numberOfCharsToReadAsString.append(chars[i]);
                i++; // go for next number
            }

            i++; // skip # sign

            int numberOfCharsToRead = Integer.parseInt(numberOfCharsToReadAsString.toString());

            for (int j = 0; j < numberOfCharsToRead && i < chars.length; j++, i++) {
                word.append(chars[i]);
            }

            result.add(word.toString());
        }

        return result;
    }
}
