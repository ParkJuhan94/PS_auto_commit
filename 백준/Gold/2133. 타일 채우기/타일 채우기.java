//package BOJ.Section04.P16236;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        if(n % 2 == 1) {
            System.out.println(0);
            return;
        }

        dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4 ; i <= n ; i+=2){
            dp[i] = (dp[i-2] * 3);
            for(int j = 0 ; j <= i-4 ; j += 2){
                dp[i] += (dp[j] * 2);
            }
        }

        System.out.println(dp[n]);
    }
}