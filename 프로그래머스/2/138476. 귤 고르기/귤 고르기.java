import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> tangerineCount = new HashMap<>();

        for (Integer tangerine_ : tangerine) {
            tangerineCount.put(tangerine_, tangerineCount.getOrDefault(tangerine_, 0) + 1);
        }

        // 1. 키를 리스트로 변환
        List<Integer> keys = new ArrayList<>(tangerineCount.keySet());

        // 2. 값 기준으로 키를 내림차순 정렬
        keys.sort((key1, key2) -> tangerineCount.get(key2) - tangerineCount.get(key1));

        int sum = 0;
        for (Integer key : keys) {
            if(sum >= k) {
                break;
            }
            sum += tangerineCount.get(key);
            answer++;
        }

        return answer;
    }
}