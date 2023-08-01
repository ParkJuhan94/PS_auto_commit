//package BOJ.Section06.P28420;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int a, b, c;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section06/P28420/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(sum1(i, j) != -1){
                    ans = Math.min(ans, sum1(i, j));
                }
                if(sum2(i, j) != -1){
                    ans = Math.min(ans, sum2(i, j));
                }
                if(sum3(i, j) != -1){
                    ans = Math.min(ans, sum3(i, j));
                }
            }
        }

        System.out.println(ans);
    }

    // 왼쪽위의 위치가 r,c
    static int sum1(int row, int col) {
        // 범위체크
        if(row + a > N || col + b + c > M){
            return -1;
        }

        int res = 0;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b + c; j++){
                res += map[row + i][col + j];
            }
        }
        return res;
    }

    // 왼쪽위의 위치가 r,c
    static int sum2(int row, int col) {
        // 범위체크
        if(row + a + b > N || col + a + c > M){
            return -1;
        }

        int res = 0;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < c; j++){
                res += map[row + i][col + j];
            }
        }
        for(int i = 0; i < b; i++){
            for(int j = 0; j < a; j++){
                res += map[row + a + i][col + c + j];
            }
        }
        return res;
    }

    // 왼쪽위의 위치가 r,c
    static int sum3(int row, int col) {
        // 범위체크
        if(row + a + c> N || col + b + a > M){
            return -1;
        }

        int res = 0;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                res += map[row + i][col + j];
            }
        }
        for(int i = 0; i < c; i++){
            for(int j = 0; j < a; j++){
                res += map[row + a + i][col + b + j];
            }
        }
        return res;
    }
}