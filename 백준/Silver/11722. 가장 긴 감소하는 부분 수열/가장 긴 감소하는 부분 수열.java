//package WEEK00.P11722;

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
       // System.setIn(new FileInputStream("src/WEEK00/P11722/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;

        for(int i = 1; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] < arr[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    //dp[i]++;    // 이렇게도 가능
                }
            }
        }

        int maxLen = 0;
        for(int i = 0; i < N; i++){
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);
    }

}