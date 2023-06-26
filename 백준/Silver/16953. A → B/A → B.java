//package WEEK000.P16953;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
      //  System.setIn(new FileInputStream("src/WEEK000/P16953/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = 1;

        while(true){
            if(N > M){
                System.out.println(-1);
                return;
            }
            if(N == M){
                break;
            }

            if(M % 10 == 1){
                M /= 10;
            }else{
                if(M % 2 == 0){
                    M /= 2;
                }else{
                    System.out.println(-1);
                    return;
                }
            }
            //System.out.println(M);

            ans++;
        }

        System.out.println(ans);
    }

}