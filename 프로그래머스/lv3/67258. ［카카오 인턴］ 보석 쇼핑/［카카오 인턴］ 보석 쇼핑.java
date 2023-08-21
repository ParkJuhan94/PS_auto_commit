import java.util.HashMap;
import java.util.HashSet;

class Solution {

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashSet<String> preSet = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            preSet.add(gems[i]);
        }
        int N = preSet.size();

        HashMap<String, Integer> map = new HashMap<>();

        // 선형 탐색
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int end = 0; end < gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            // 보석 갯수 최적화 (start 이동)
            while(map.get(gems[start]) > 1){
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            // 쇼핑 습관에 맞으면
            if(map.size() == N){
                if(end - start + 1 < minLen){
                    minLen = end - start + 1;

                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
            }
        }

        return answer;
    }
}