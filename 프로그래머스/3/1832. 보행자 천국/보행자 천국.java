import java.util.*;

class Solution {
    static int MOD = 20170805;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][][] dp;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
       
        dp = new int[m][n][2];      // 위 -> 아래 : 0 , 왼 -> 오 : 1
        
        dp(m,n,cityMap);
           
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) %MOD;
    }
    
    
      static void dp(int m, int n, int[][] cityMap) {

        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) break;
            dp[i][0][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (cityMap[0][j] == 1) break;
            dp[0][j][1] = 1;
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                if (cityMap[x - 1][y] != 1) {          // 위에서 아래
                    if (cityMap[x - 1][y] == 0) {
                        dp[x][y][0] = (dp[x - 1][y][0] + dp[x - 1][y][1]) % MOD;
                    } else {
                        dp[x][y][0] = dp[x - 1][y][0];
                    }
                }

                if (cityMap[x][y - 1] != 1) {        // 왼쪽에서 오른쪽
                    if (cityMap[x][y - 1] == 0) {
                        dp[x][y][1] = (dp[x][y - 1][0] + dp[x][y - 1][1]) % MOD;
                    } else {
                        dp[x][y][1] = dp[x][y - 1][1];
                    }
                }

            }
        }
        
    }
    
    
}