package com.gul.web2.xxx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedValue2 {

	public static void main(String[] args) {

		Map<Integer, Integer> countMap2 = new HashMap<>();

		List<Integer> mixedList = List.of(2323, 23232, 35353, 23232, 2323, 23232, 23232, 23232, 23232,
				23232, 23232

		);

		for (Integer s : mixedList) {
			countMap2.put(s, countMap2.getOrDefault(s, 0) + 1);
		}

		//

//		List<Integer> result = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : countMap2.entrySet()) {
			if (entry.getValue() <= 2) {
				System.out.println("found: " + entry.getValue());
			}
		}

	}
}
