//package WEEK20.P1463;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Integer[] dp;    // 메모이제이션 할 배열

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK20/P1463/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int dp[] = new int[number+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= number; i++){
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[number]);
        br.close();
    }
}