import java.util.*;

class Solution {
    public int solution(int[] array) {
        // 숫자와 빈도를 저장할 HashMap 선언
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // 배열의 각 숫자의 빈도수 세기
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 최빈값과 빈도를 저장할 변수
        int maxFrequency = 0;
        int mode = -1;
        boolean isMultiple = false;

        // HashMap을 순회하며 최빈값 찾기
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = key;
                isMultiple = false; // 최빈값이 여러 개일 경우를 처리하기 위해
            } else if (frequency == maxFrequency) {
                isMultiple = true;  // 빈도가 같은 값이 있으면 여러 개가 있다는 표시
            }
        }

        // 최빈값이 여러 개일 경우 -1 반환
        return isMultiple ? -1 : mode;
    }
}