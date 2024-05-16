class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};

        if(s < n) {
            answer = new int[]{-1};
        }else{
            int divide = s / n;
            if(s % n == 0) {
                answer = new int[] {divide, divide};
            }else{
                int diff = s % n;
                
                answer = new int[n];
                // 앞쪽
                for(int i = 0; i < n - diff; i++) {
                    answer[i] = divide;
                }
                // 뒤쪽 
                for(int i = n - diff; i < n; i++) {
                    answer[i] = divide + 1;
                }
            }
        }

        return answer;
    }
}