//package WEEK00.P1912;

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
       // System.setIn(new FileInputStream("src/WEEK00/P1912/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp는 해당 원소를 포함하는 연속합의 최대값
        int[] dp = new int[N];
        dp[0] = arr[0];

        for(int i = 1; i < N; i++){
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

}