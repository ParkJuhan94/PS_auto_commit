class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;

        // 스티커가 하나 또는 두개인 경우 return
        if(N == 1) return sticker[0];
        if(N == 2) return Math.max(sticker[0], sticker[1]);

        // dp[0][i] : i번 안 뜯었을 때 최댓값
        // dp[1][i] : i번 뜯었을 때 최댓값
        int[][] dp = new int[2][100_001];

        // 첫번째 스티커 사용 O
        dp[0][0] = sticker[0];
        dp[0][1] = sticker[0];
        // 첫번째 스티커 사용 X
        dp[1][0] = 0;
        dp[1][1] = sticker[1];

        // 마지막 스티커보다 하나 전 까지
        for(int i = 2; i < N - 1; i++){
            dp[0][i] = Math.max(dp[0][i - 2] + sticker[i], dp[0][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 2] + sticker[i], dp[1][i - 1]);
        }

        // 첫번째 스티커 안 뜯었으면 마지막 스티커 뜯기
        dp[1][N - 1] = Math.max(dp[1][N - 3] + sticker[N - 1], dp[1][N - 2]);
        int answer = Math.max(dp[0][N - 2], dp[1][N - 1]);

        return answer;
    }

}