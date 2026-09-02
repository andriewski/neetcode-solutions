package by.mrk.neetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * <a href="https://neetcode.io/problems/top-k-elements-in-list/question">Top K Frequent Elements</a>
 */
public class Solution5 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> number2Frequency = new HashMap<>();

        for (int num : nums) {
            number2Frequency.merge(num, 1, Integer::sum);
        }

        List<List<Integer>> frequency2Numbers = new ArrayList<>(Collections.nCopies(nums.length, null));

        for (var number2FrequencyEntry : number2Frequency.entrySet()) {
            Integer number = number2FrequencyEntry.getKey();
            Integer frequency = number2FrequencyEntry.getValue();

            if (frequency2Numbers.get(internalIndex(frequency)) == null) {
                frequency2Numbers.set(internalIndex(frequency), new ArrayList<>());
            }

            frequency2Numbers.get(internalIndex(frequency)).add(number);
        }

        List<Integer> topKFrequentResult = new ArrayList<>();

        for (int i = nums.length; i > 0; i--) {
            List<Integer> numbersForFrequency = frequency2Numbers.get(internalIndex(i));

            if (numbersForFrequency != null) {
                for (Integer number : numbersForFrequency) {
                    topKFrequentResult.add(number);

                    if (topKFrequentResult.size() == k) {
                        return toIntArray(topKFrequentResult);
                    }
                }
            }
        }

        return toIntArray(topKFrequentResult);
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> number2Frequency = new HashMap<>();

        for (int num : nums) {
            number2Frequency.merge(num, 1, Integer::sum);
        }

        List<Integer>[] frequency2Numbers = new ArrayList[nums.length + 1];

        for (var number2FrequencyEntry : number2Frequency.entrySet()) {
            Integer number = number2FrequencyEntry.getKey();
            Integer frequency = number2FrequencyEntry.getValue();

            if (frequency2Numbers[internalIndex(frequency)] == null) {
                frequency2Numbers[internalIndex(frequency)] = new ArrayList<>(k);
            }

            frequency2Numbers[internalIndex(frequency)].add(number);
        }

        List<Integer> topKFrequentResult = new ArrayList<>();

        for (int i = nums.length; i > 0; i--) {
            List<Integer> numbersForFrequency = frequency2Numbers[internalIndex(i)];

            if (numbersForFrequency != null) {
                for (Integer number : numbersForFrequency) {
                    topKFrequentResult.add(number);

                    if (topKFrequentResult.size() == k) {
                        return toIntArray(topKFrequentResult);
                    }
                }
            }
        }

        return toIntArray(topKFrequentResult);
    }

    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> number2Frequency = new HashMap<>();
        Map<Integer, List<Integer>> frequency2Numbers = new HashMap<>();

        for (int num : nums) {
            number2Frequency.merge(num, 1, Integer::sum);
        }

        for (var number2FrequencyEntry : number2Frequency.entrySet()) {
            Integer number = number2FrequencyEntry.getKey();
            Integer frequency = number2FrequencyEntry.getValue();

            frequency2Numbers.computeIfAbsent(frequency, key -> new ArrayList<>());
            frequency2Numbers.get(frequency).add(number);
        }

        List<Integer> topKFrequentResult = new ArrayList<>();

        for (int i = nums.length; i > 0; i--) {
            List<Integer> numbersForFrequency = frequency2Numbers.get(i);

            if (numbersForFrequency != null) {
                for (Integer number : numbersForFrequency) {
                    topKFrequentResult.add(number);

                    if (topKFrequentResult.size() == k) {
                        return toIntArray(topKFrequentResult);
                    }
                }
            }
        }

        return toIntArray(topKFrequentResult);
    }

    public int[] topKFrequent4(int[] nums, int k) {
        Map<Integer, Integer> number2Frequency = new HashMap<>();
        Map<Integer, Set<Integer>> frequency2Numbers = new TreeMap<>(Comparator.reverseOrder());

        for (int num : nums) {
            number2Frequency.merge(num, 1, Integer::sum);
        }

        for (var number2FrequencyEntry : number2Frequency.entrySet()) {
            Integer number = number2FrequencyEntry.getKey();
            Integer frequency = number2FrequencyEntry.getValue();

            frequency2Numbers.computeIfAbsent(frequency, key -> new HashSet<>());
            frequency2Numbers.get(frequency).add(number);
        }

        var iterator = frequency2Numbers.entrySet().iterator();

        List<Integer> topKFrequentResult = new ArrayList<>();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Set<Integer>> descendingFrequency2Numbers = iterator.next();

            for (Integer number : descendingFrequency2Numbers.getValue()) {
                topKFrequentResult.add(number);

                if (topKFrequentResult.size() == k) {
                    return toIntArray(topKFrequentResult);
                }
            }
        }

        return toIntArray(topKFrequentResult);
    }

    private static int[] toIntArray(List<Integer> topKFrequentResult) {
        return topKFrequentResult.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int internalIndex(int i) {
        return i - 1;
    }
}
