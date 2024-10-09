import java.util.*;

class Solution {
    public String solution(String s) {
 // 문자 빈도를 저장할 HashMap
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 각 문자 빈도를 카운트
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        // 한 번만 등장한 문자를 저장할 리스트
        List<Character> singleChars = new ArrayList<>();
        for(char key : map.keySet()) {
            if(map.get(key) == 1) {
                singleChars.add(key);
            }
        }
        
        // 리스트를 사전 순으로 정렬
        Collections.sort(singleChars);
        
        // 리스트를 문자열로 변환
        StringBuilder answer = new StringBuilder();
        for(char c : singleChars) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}