import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for(int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> countMap = new HashMap<>();
            for(int j = i; j < i + 10; j++) {
                countMap.put(discount[j], countMap.getOrDefault(discount[j], 0) + 1);
            }

            // 검증
            boolean isPossible = true;
            for(int j = 0; j < want.length; j++){
                if(countMap.getOrDefault(want[j], 0) < number[j]) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) answer++;
        }


        return answer;
    }
}