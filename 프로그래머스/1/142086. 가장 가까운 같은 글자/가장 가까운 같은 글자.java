import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> lastSeen = new HashMap<>(); // 문자의 마지막 위치 저장

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (lastSeen.containsKey(currentChar)) {
                // 이전 위치가 존재하면 위치 차이를 계산
                answer[i] = i - lastSeen.get(currentChar);
            } else {
                // 이전 위치가 없으면 -1 저장
                answer[i] = -1;
            }
            
            // 현재 문자의 위치 갱신
            lastSeen.put(currentChar, i);
        }
        
        return answer;
    }
}
