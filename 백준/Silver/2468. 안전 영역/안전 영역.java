//package WEEK0.P2468;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] ch;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK0/P2468/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = -1;
        int sum = 0;

        for(int limit = 0; limit <= 100; limit++){
            sum = 0;
            ch = new boolean[N][N];
            Queue<Point> q = new LinkedList<>();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    // 잠기는 영역 찾기
                    if(map[i][j] > limit && !ch[i][j]){
                        q.add(new Point(i, j));
                        sum++;

                        // 퍼뜨리기
                        while(!q.isEmpty()){
                            Point cur = q.poll();
                            ch[cur.r][cur.c] = true;

                            for(int d = 0; d < 4; d++){
                                int nr = cur.r + dr[d];
                                int nc = cur.c + dc[d];

                                if(0 <= nr && nr < N && 0 <= nc && nc < N &&
                                        map[nr][nc] > limit && !ch[nr][nc]){
                                    ch[nr][nc] = true;
                                    q.add(new Point(nr, nc));
                                }
                            }
                        }
                    }
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}