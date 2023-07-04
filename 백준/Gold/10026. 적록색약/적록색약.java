//package BOJ.Section05.P10026;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][][] ch;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<Point> q;
    static int[] ans = {0, 0};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section05/P10026/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        ch = new int[2][N][N];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = input.charAt(j);
            }
        }

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (ch[k][i][j] == 0) {
                        dfs(i, j, ch[k], map[i][j]);
                        ans[k]++;
                    }
                    if (map[i][j] == 'G')
                        map[i][j] = 'R';
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    static void dfs(int r, int c, int[][] visit, char ch) {
        visit[r][c] = 1;

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nc < 0 || nr < 0 || nc >= N || nr >= N ||
                    visit[nr][nc] == 1 || map[nr][nc] != ch)
                continue;
            dfs(nr, nc, visit, ch);
        }
    }
}