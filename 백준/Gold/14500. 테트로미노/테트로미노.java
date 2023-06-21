//package WEEK0.P14500;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] ch;
    static int ans;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK0/P14500/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ch = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                ch[i][j] = true;
                search(i, j, 1, map[i][j]);
                ch[i][j] = false;
            }
        }

        System.out.print(ans);
    }

    // dfs : 해당 점을 포함하는 모든 테트로미노를 구함
    static void search(int x, int y, int cnt, int sum){
        if(cnt == 4){
            ans = Math.max(sum, ans);
            return;
        }

        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(0 <= xx && xx < N && 0 <= yy && yy < M
                    && !ch[xx][yy]){
                // 분홍색(ㅜ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
                if(cnt == 2){
                    ch[xx][yy] = true;
                    search(x, y, cnt + 1, sum + map[xx][yy]);
                    ch[xx][yy] = false;
                }

                ch[xx][yy] = true;
                search(xx, yy, cnt + 1, sum + map[xx][yy]);
                ch[xx][yy] = false;
            }
        }
    }

}