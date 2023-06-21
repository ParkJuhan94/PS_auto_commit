//package WEEK00.P11054;

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
    static int[] dp1;
    static int[] dp2;
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK00/P11054/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N]; // 증가하는 부분 수열의 길이를 저장하는 배열
        int[] dp2 = new int[N]; // 감소하는 부분 수열의 길이를 저장하는 배열
        int[] dp = new int[N]; // 바이토닉 부분 수열의 길이를 저장하는 배열

        // 증가
        // dp1[i]는 수열의 i번째 원소를 마지막으로 하는 증가하는 부분 수열의 최대 길이
        for (int i = 0; i < N; i++) {
            dp1[i] = 1; // 각 원소의 길이는 최소 1로 초기화
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp1[j] + 1 > dp1[i]) {
                    dp1[i] = dp1[j] + 1; // 증가하는 순서를 만족하고 더 긴 길이라면 업데이트
                }
            }
        }

        // 감소
        // dp2[i]는 수열의 i번째 원소를 시작으로 하는 감소하는 부분 수열의 최대 길이
        for (int i = N - 1; i >= 0; i--) {
            dp2[i] = 1; // 각 원소의 길이는 최소 1로 초기화
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i] && dp2[j] + 1 > dp2[i]) {
                    dp2[i] = dp2[j] + 1; // 감소하는 순서를 만족하고 더 긴 길이라면 업데이트
                }
            }
        }


        // 바이토닉
        // 정수 i가 2번 카운팅되니까 -1 해준다
        for(int i = 0; i < N; i++){
            dp[i] = dp1[i] + dp2[i] - 1;
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