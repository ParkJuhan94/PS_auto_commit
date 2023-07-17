//package BOJ.Section05.P1793;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section05/P1793/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[251];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        String input = "";
        while((input = br.readLine()) != null){
            N = Integer.parseInt(input);

            for(int i = 3; i <= N; i++){
                //dp[i] = (dp[i - 2] * 2 + dp[i - 1]);
                dp[i] = new BigInteger("0");
                dp[i] = dp[i].add(dp[i - 2].multiply(new BigInteger("2")));
                dp[i] = dp[i].add(dp[i - 1]);
            }

            System.out.println(dp[N]);
        }
    }

}