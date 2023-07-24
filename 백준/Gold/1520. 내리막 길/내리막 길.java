//package BOJ.Section06.P1520;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] ch;
    static int[][] dp;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P1520/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ch = new int[N][M];
        dp = new int[N][M]; // 해당 지점까지 오는 경로의 수를 저장
        for(int i =0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));

        //printDP();
    }

    // 탑바틈 (분할정복 느낌)
    static int dfs(int r, int c){

        if(r == N - 1 && c == M - 1){
            return dp[r][c] = 1;   // 끝에 도달한 경우 1로 계산
        }

        if(dp[r][c] != -1){ // 방문했던 지점일 경우 경로단축
            return dp[r][c];
        }else
        {
            dp[r][c] = 0;

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(0 <= nr && nr < N && 0 <= nc && nc < M){
                    if(map[nr][nc] < map[r][c])
                    {
                        dp[r][c] += dfs(nr, nc);
                    }
                }
            }
        }

        return dp[r][c];
    }

    static void printDP(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(dp[i][j] >= 0){
                    System.out.print(" " + dp[i][j] + " ");
                }else{
                    System.out.print(dp[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}