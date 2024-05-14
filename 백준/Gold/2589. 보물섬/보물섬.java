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
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section10/P2589/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        solve();

        System.out.println(ans);
    }

    static void solve() {
        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited = new boolean[N][M];

                if(map[i][j] == 'L') {
                    q.add(new Point(i, j, 0));
                    visited[i][j] = true;
                    int maxDist = 0;

                    while(!q.isEmpty()) {
                        Point cur = q.poll();
                        maxDist = Math.max(maxDist, cur.dist);

                        for(int k = 0; k < 4; k++) {
                            int nr = cur.r + dr[k];
                            int nc = cur.c + dc[k];

                            if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] == 'L') {
                                q.add(new Point(nr, nc, cur.dist + 1));
                                visited[nr][nc] = true;
                            }
                        }
                    }

                    ans = Math.max(ans, maxDist);
                }
            }
        }
    }
}

class Point{
    int r;
    int c;
    int dist;

    public Point(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}