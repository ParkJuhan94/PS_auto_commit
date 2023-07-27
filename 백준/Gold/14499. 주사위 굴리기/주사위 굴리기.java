//package BOJ.Section06.P14499;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, r, c, K;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section06/P14499/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // top, up, down, left, right, bottom
        Dice cur = new Dice(0, 1, 2, 3, 4, 5);
        int[] dice = new int[6]; // 주사위 각 면의 값을 저장할 배열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int k = Integer.parseInt(st.nextToken());
            k--;

            // 굴리기 전 주사위 상태
            int t = cur.top;
            int u = cur.up;
            int d = cur.down;
            int lt = cur.left;
            int rt = cur.right;
            int b = cur.bottom;

            Dice next;  // 굴린 후의 주사위

            // 0 1 2 3 을 상하좌우의 순서로 저장
            if(k == 0) {
                next = new Dice(lt, u, d, b, t, rt);
            } else if(k == 1) {
                next = new Dice(rt, u, d, t, b, lt);
            } else if(k == 2) {
                next = new Dice(u, b, t, lt, rt, d);
            } else {
                next = new Dice(d, t, b, lt, rt, u);
            }

            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

            // 주사위 위치 변경
            r = nr;
            c = nc;
            // 굴릴 수 있는 경우: 현재 주사위를 굴린 후의 주사위 상태로 변경
            cur = next;

            // 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다
            if(map[nr][nc] == 0) {
                map[nr][nc] = dice[next.bottom];
                System.out.println(dice[next.top]);
            } else { // 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사된다
                dice[next.bottom] = map[nr][nc];
                map[nr][nc] = 0; // 칸에 쓰여 있는 수는 0이 된다
                System.out.println(dice[next.top]);
            }
        }
    }
}

class Dice {
    int top, up, down, left, right, bottom;

    Dice(int top, int up, int down, int left, int right, int bottom) {
        this.top = top;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }
}