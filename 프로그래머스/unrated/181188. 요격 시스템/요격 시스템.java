import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        // O(N) 으로 끝내야 해 (N = 1억)

        // 2차원 배열 정렬 : Lambda 사용
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int boundary = -1;

        for(int i = 0; i < targets.length; i++){
            int s = targets[i][0];
            int e = targets[i][1];

            if(s >= boundary){
                boundary = e;
                answer++;
            }
        }

        return answer;
    }
}