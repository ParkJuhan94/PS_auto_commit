//package WEEK000.P2206;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Loc{
        int row;
        int col;
        int cnt;
        boolean destroyed;

        public Loc(int row, int col, int cnt, boolean d) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.destroyed = d;
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK000/P2206/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 1, false));

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        // visited[n][m][0]은 벽을 한 번도 안 부순 경로인 경우
        // visited[n][m][1]은 벽을 한 번 부수고 탐색한 경로인 경우
        boolean[][][] visited = new boolean[n][m][2];

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

                int nextCnt = cur.cnt+1;

                if(map[nr][nc]=='0'){
                    if(!cur.destroyed && !visited[nr][nc][0]) { // 부신 벽이 여태까지 없었으면
                        q.add(new Loc(nr, nc, nextCnt, false));
                        visited[nr][nc][0] = true;
                    }else if(cur.destroyed && !visited[nr][nc][1]){ // 벽을 한번 부신 적이 있으면
                        q.add(new Loc(nr, nc, nextCnt, true));
                        visited[nr][nc][1] = true;
                    }

                }else if(map[nr][nc]=='1'){

                    if(!cur.destroyed){ // 한번도 벽을 부순적이 없다면 부순다~
                        q.add(new Loc(nr, nc, nextCnt, true));
                        visited[nr][nc][1] = true;
                    }
                    // 한번 부순 적이 있다면 또 부수고 갈 수 없기 때문에 pass
                }
            }

        }

        System.out.println(-1);
    }
}