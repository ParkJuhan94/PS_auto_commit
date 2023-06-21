//package WEEK00.P5525;

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
      //  System.setIn(new FileInputStream("src/WEEK00/P5525/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int patternCnt = 0;
        for(int i = 0; i < M - 2; i++){
            if(str.charAt(i) == 'I'){
                if(str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I'){
                    patternCnt++;
                }else{
                    patternCnt = 0;
                }
            }
            if(patternCnt == N){
                ans++;
                patternCnt--;
            }
        }



        System.out.println(ans);
    }

}