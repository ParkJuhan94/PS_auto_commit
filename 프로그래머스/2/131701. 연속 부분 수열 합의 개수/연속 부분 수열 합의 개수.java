import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        // 값 추가
        int len = elements.length; 
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                int sum = 0;
                for(int k = j; k < j + i; k++) {
                    sum += elements[(k + len) % len];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}