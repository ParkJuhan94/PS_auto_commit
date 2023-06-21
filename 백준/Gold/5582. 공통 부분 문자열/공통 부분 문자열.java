//package WEEK00.P5582;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-5582-%EA%B3%B5%ED%86%B5-%EB%B6%80%EB%B6%84-%EB%AC%B8%EC%9E%90%EC%97%B4-Java

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
        //System.setIn(new FileInputStream("src/WEEK00/P5582/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        String str1 = st.nextToken();
        String str2 = br.readLine();
        int lenStr1 = str1.length();
        int lenStr2 = str2.length();

        // dp 각 칸이 의미하는 바는, 해당 행과 열까지의 문자만을 사용했을 때의 공통 부분 문자열의 갯수이다.
        int[][] dp = new int[lenStr1 + 1][lenStr2 + 1];
        int maxLen = 0; // 가장 긴 공통 부분 문자열의 길이

        for(int i = 1; i <= lenStr1; i++){
            for(int j = 1; j <= lenStr2; j++){
                // 현재 문자가 두 문자열에서 동일한 경우,
                // 이전 문자까지의 공통 부분 문자열의 길이에 1을 더한 값을 현재 위치의 dp 배열에 저장합니다.
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        System.out.println(maxLen);
    }

}