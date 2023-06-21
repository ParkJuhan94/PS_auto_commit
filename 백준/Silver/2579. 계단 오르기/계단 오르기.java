//package WEEK00.P2579;

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
     //   System.setIn(new FileInputStream("src/WEEK00/P2579/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = arr[1];
        if(N >= 2){
            dp[2] = arr[1] + arr[2];
        }

        for(int i = 3; i <= N; i++){
            // 1up : 이전 계단을 밟았으면 이전이전 계단은 안밟았어야함
            // 2up : 이전 계단을 안 밟았으면 괜찮음
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }

        System.out.println(dp[N]);
    }

}