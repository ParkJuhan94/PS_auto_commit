import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 각 문자가 최소 몇 번 눌려야 하는지 저장하는 Map
        Map<Character, Integer> minKeyPresses = new HashMap<>();
        
        // keymap을 순회하면서 각 문자의 최소 키 입력 횟수를 저장
        for (int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            for (int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                int pressCount = j + 1; // 키를 누르는 횟수는 인덱스 + 1
                minKeyPresses.put(c, Math.min(minKeyPresses.getOrDefault(c, Integer.MAX_VALUE), pressCount));
            }
        }
        
        // 결과 배열을 targets의 길이만큼 생성
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPresses = 0;
            boolean isPossible = true;
            
            // 각 target 문자열의 문자들을 검사
            for (char c : target.toCharArray()) {
                if (!minKeyPresses.containsKey(c)) {
                    isPossible = false;
                    break;
                } else {
                    totalPresses += minKeyPresses.get(c);
                }
            }
            
            // 작성이 불가능한 경우 -1, 가능하면 총 키 입력 횟수 저장
            answer[i] = isPossible ? totalPresses : -1;
        }
        
        return answer;
    }
}
