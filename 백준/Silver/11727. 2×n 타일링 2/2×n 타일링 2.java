//package BOJ.Section05.P11727;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section05/P11727/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        long[] dp = new long[1002];
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= N; i++){
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }

        System.out.println(dp[N]);
    }

}