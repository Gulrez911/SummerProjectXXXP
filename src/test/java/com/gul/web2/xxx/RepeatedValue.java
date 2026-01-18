package com.gul.web2.xxx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedValue {

    public static List<String> getValuesWithFiveRepeats(List<String> list) {
        Map<String, Integer> countMap = new HashMap<>();

        // Count occurrences
        for (String s : list) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }

        // Collect only values that occur exactly 5 times
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 5) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> mixedList = List.of(
            "apple", "banana", "apple", "orange", "banana",
            "apple", "kiwi", "banana", "apple", "banana",
            "apple", "banana"
        );

        List<String> fiveRepeats = getValuesWithFiveRepeats(mixedList);
        System.out.println("Values repeated exactly 5 times: " + fiveRepeats);
    }
}
