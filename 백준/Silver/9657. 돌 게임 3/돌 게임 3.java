//package WEEK000.P9660;

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
        //System.setIn(new FileInputStream("src/WEEK000/P9660/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        // dp[i] 가 1이라면 상근이가 돌이 i개일 때 승리할 수 있는 것
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;
        dp[5] = 1;

        // 현재 턴에서 n 개를 뺐을 때, 상대방이 이기는 상황으로 만드는게 최선!! (턴이 뒤바뀌니까)
        for(int i = 6; i <= N; i++){
            // 이전 상태에서 창영이가 이기는 경우가 있으면 상근이가 이김
            // 상근이가 n 개를 가져가서 이전 상태를 만들면 되니까 (첫 턴은 뒤바뀜)
            if(dp[i - 1] == 0 || dp[i - 3] == 0 || dp[i - 4] == 0){
                dp[i] = 1;
            }
        }

        if(dp[N] == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }

}