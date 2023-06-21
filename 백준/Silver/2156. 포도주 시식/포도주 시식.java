//package WEEK00.P2156;

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
        //System.setIn(new FileInputStream("src/WEEK00/P2156/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[10002];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // dp[i]는 i번째 잔 순서까지 왔을 때 최대 양
        int[] dp = new int[10002];
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for(int i = 3; i <= N; i++){
            // 현재를 마시고 이전 마시고
            // 현재를 마시고 이전 안 마시고
            // 현재를 안 마시고

            dp[i] = Math.max(arr[i] + arr[i - 1] + dp[i - 3], Math.max(arr[i] + dp[i - 2], dp[i - 1]));
        }

        System.out.println(dp[N]);
    }

}