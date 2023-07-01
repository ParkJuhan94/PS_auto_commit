// https://bbeomgeun.tistory.com/30

class Solution {

    long[] dp;
    int MOD = 1_000_000_007;

    public int solution(int n) {

        if(n % 2 == 1) return 0;

        dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4 ; i <= n ; i+=2){
            dp[i] = (dp[i-2] * 3);  // 기본 도형으로만 

            // special case
            for(int j = 0 ; j <= i-4 ; j += 2){     
                dp[i] += (dp[j] * 2) % MOD;
            }
            
            dp[i] %= MOD;
        }

        return (int)(dp[n] % MOD);
    }
}

