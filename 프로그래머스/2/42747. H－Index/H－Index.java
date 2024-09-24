class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        int max = 0;
        for(int i = 0; i < citations.length; i++) {
            max = Math.max(max, citations[i]);
        }

        for(int i = max; i >= 0; i--) {
            int count = 0;

            for(int j = 0; j < citations.length; j++) {
                if(i <= citations[j]) {
                    count++;
                }
            }

            if(count >= i) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}