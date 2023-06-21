//package WEEK000.P14442;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Loc{
        int row;
        int col;
        int cnt;
        int destroyedCnt;  // 현재까지 부순 벽의 개수

        public Loc(int row, int col, int cnt, int d) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.destroyedCnt = d;
        }
    }

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK000/P14442/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 1, 0));

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        // visited[n][m][0]은 벽을 한 번도 안 부순 경로인 경우
        // visited[n][m][1]은 벽을 한 번 부수고 탐색한 경로인 경우
        boolean[][][] visited = new boolean[n][m][K + 1];
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Loc cur = q.poll();

            if (cur.row == n - 1 && cur.col == m - 1) {
                System.out.println(cur.cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

                int nextCnt = cur.cnt + 1;
                int destCnt = cur.destroyedCnt;

                if(map[nr][nc] == '0' && !visited[nr][nc][destCnt]){
                    q.add(new Loc(nr, nc, nextCnt, destCnt));
                    visited[nr][nc][destCnt] = true;

                }else if(map[nr][nc] == '1'){

                    if(destCnt < K){
                        if(!visited[nr][nc][destCnt + 1]){
                            q.add(new Loc(nr, nc, nextCnt, destCnt + 1));   // 부수는 경우
                            visited[nr][nc][destCnt + 1] = true;
                        }
                    }
                }
            }

        }

        System.out.println(-1);
    }
}