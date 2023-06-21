//package WEEK00.P2775;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
       // System.setIn(new FileInputStream("src/WEEK00/P2775/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            // N층 M호
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            int[][] dp = new int[N + 1][M + 1];
            for(int i = 1; i <= M; i++){
                dp[0][i] = i;
            }

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    for(int a = 1; a <= j; a++){
                        dp[i][j] += dp[i - 1][a];
                    }
                }
            }

            System.out.println(dp[N][M]);
        }
    }

}