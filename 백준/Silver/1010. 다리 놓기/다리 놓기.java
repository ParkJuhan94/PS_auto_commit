//package BOJ.Section04.P1010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R, ans;
    private static final int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section04/P1010/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            System.out.println(combination(N, R));
        }
    }

    private static int combination(int n, int r)
    {
        // 이미 계산된 값일 경우
        if (dp[n][r] > 0)
        {
            return dp[n][r];
        }

        // bottom 설정
        // 원소의 갯수가 조합의 갯수와 동일하거나 0일 경우
        // 1로 설정하면서 dp 갱신
        else if (n == r || r == 0)
        {
            return dp[n][r] = 1;
        }

        // 일반적인 경우 : 재귀로 더하면서 dp 에 갱신
        else
        {
            return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }

}