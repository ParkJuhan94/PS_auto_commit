//package WEEK000.P1007;

import java.awt.*;
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
    static long ans;
    static StringBuilder sb;
    static int[] selected;
    static Point[] points;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK000/P1007/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0 ; t < T; t++){
            N = Integer.parseInt(br.readLine());
            selected = new int[N];
            points = new Point[N];
            ans = Long.MAX_VALUE;

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                points[i] = new Point(r, c);
            }

            search(0, 0);

            System.out.println(Math.sqrt(ans));
        }

    }

    // 벡터의 조합
    static void search(int idx, int count){
        if(count == N / 2){
            calculate();
            return;
        }

        if(idx >= N){
            return;
        }

        // selected 가 0 일땐 출발점, 1일땐 도착점
        selected[idx] = 1;
        search(idx + 1, count + 1);
        selected[idx] = 0;
        search(idx + 1, count);
    }

    // 벡터의 합 계산
    static void calculate(){
        long rDiff = 0;
        long cDiff = 0;

        for(int i = 0; i < N; i++){
            if(selected[i] == 1){
                rDiff += points[i].x;
                cDiff += points[i].y;
            }else{
                rDiff -= points[i].x;
                cDiff -= points[i].y;
            }
        }

        long diff = (rDiff * rDiff) + (cDiff * cDiff);

        // 계산해서 최솟값으로 갱신
        ans = Math.min(ans, diff);
    }

}