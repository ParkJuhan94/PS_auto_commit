//package WEEK00.P1149;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK00/P1149/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        map = new int[N][3];
        int[][] dp = new int[N][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        // dp 만들기
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 3; j++){
                dp[i][j] = map[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }

        ans = Math.min(dp[N - 1][0], dp[N - 1][1]);
        ans = Math.min(ans, dp[N - 1][2]);

        //System.out.print(sb);
        System.out.println(ans);
    }
}