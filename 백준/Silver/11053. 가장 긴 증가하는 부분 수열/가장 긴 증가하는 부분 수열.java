//package WEEK00.P11053;

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
    static int[] dp;
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK00/P11053/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //dp[i]는 수열의 i번째 원소를 마지막으로 하는 증가하는 부분 수열의 최대 길이를 나타냄
        dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1; // 각 원소의 길이는 최소 1로 초기화
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1; // 증가하는 순서를 만족하고 더 긴 길이라면 업데이트
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        System.out.println(maxLength);
    }

}