// package Programmers.Level_2.뉴스클러스터링;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
	public int solution(String str1, String str2) {
		int answer = 0;

		Queue<String> arr1 = new LinkedList<>();
		Queue<String> arr2 = new LinkedList<>();

		// str1 의 집합 만들기
		for (int i = 0; i < str1.length() - 1; i++) {
			String partialStr = str1.substring(i, i + 2);
			if ((('A' <= partialStr.charAt(0) && partialStr.charAt(0) <= 'Z') ||
				('a' <= partialStr.charAt(0) && partialStr.charAt(0) <= 'z')) &&
				(('A' <= partialStr.charAt(1) && partialStr.charAt(1) <= 'Z') ||
					('a' <= partialStr.charAt(1) && partialStr.charAt(1) <= 'z'))) {
				arr1.add(partialStr.toUpperCase());
			}
		}

		// str2 의 집합 만들기
		for (int i = 0; i < str2.length() - 1; i++) {
			String partialStr = str2.substring(i, i + 2);
			if ((('A' <= partialStr.charAt(0) && partialStr.charAt(0) <= 'Z') ||
				('a' <= partialStr.charAt(0) && partialStr.charAt(0) <= 'z')) &&
				(('A' <= partialStr.charAt(1) && partialStr.charAt(1) <= 'Z') ||
					('a' <= partialStr.charAt(1) && partialStr.charAt(1) <= 'z'))) {
				arr2.add(partialStr.toUpperCase());
			}
		}

		// map 만들기
		Map<String, Integer> mapArr1 = new HashMap<>();
		Map<String, Integer> mapArr2 = new HashMap<>();

		while (!arr1.isEmpty()) {
			String cur = arr1.poll();
			if (!mapArr1.containsKey(cur)) {
				mapArr1.put(cur, 1);
			} else {
				mapArr1.put(cur, mapArr1.get(cur) + 1);
			}
		}

		while (!arr2.isEmpty()) {
			String cur = arr2.poll();
			if (!mapArr2.containsKey(cur)) {
				mapArr2.put(cur, 1);
			} else {
				mapArr2.put(cur, mapArr2.get(cur) + 1);
			}
		}

		// 교집합
		int countAndSet = 0;

		for (String key1 : mapArr1.keySet()) {
			for (String key2 : mapArr2.keySet()) {
				if (key1.equals(key2)) {
					countAndSet += Math.min(mapArr1.get(key1), mapArr2.get(key2));
					break;
				}
			}
		}

		// 합집합
		Map<String, Integer> mapOrSet = new HashMap<>(mapArr1);
		int countOrSet = 0;

		for (String key : mapArr2.keySet()) {
			if (!mapArr1.containsKey(key)) {
				mapOrSet.put(key, mapArr2.get(key));
			} else {
				mapOrSet.put(key, Math.max(mapOrSet.get(key), mapArr2.get(key)));
			}
		}

		for (String key : mapOrSet.keySet()) {
			countOrSet += mapOrSet.get(key);
		}

		// 유사도 구하기
		if (countOrSet == 0) {
			answer = 65536;
		} else {
			answer = countAndSet * 65536 / countOrSet;
		}

		return answer;
	}
}
