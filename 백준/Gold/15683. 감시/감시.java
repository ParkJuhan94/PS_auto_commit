//package BOJ.Section06.P15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        ArrayList<Point> cctvs = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 벽이나 빈 곳이 아닌 경우 -> cctv
                if(map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new Point(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map, cctvs);
        System.out.println(min);
    }

    public static void dfs(int cnt, int[][] map, ArrayList<Point> cctv) {
        if(cnt == cctv.size()) {
            min = Math.min(min, numZero(map));
            return;
        }

        int cctvNum = cctv.get(cnt).idx;
        int r = cctv.get(cnt).r;
        int c = cctv.get(cnt).c;
        int[][] tmp;

        if(cctvNum == 1) {
            tmp = copyMap(map);
            checkLeft(tmp, r, c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkRight(tmp, r, c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkDown(tmp, r, c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkUp(tmp, r, c);
            dfs(cnt+1, tmp, cctv);
        } else if (cctvNum == 2) {
            tmp = copyMap(map);
            checkLeft(tmp, r, c);
            checkRight(tmp, r, c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkUp(tmp, r, c);
            checkDown(tmp, r, c);
            dfs(cnt+1, tmp, cctv);
        } else if (cctvNum == 3) {
            tmp = copyMap(map);
            checkLeft(tmp, r, c);
            checkUp(tmp, r, c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkUp(tmp, r, c);
            checkRight(tmp, r, c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkRight(tmp, r, c);
            checkDown(tmp, r, c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkDown(tmp, r, c);
            checkLeft(tmp, r, c);
            dfs(cnt+1, tmp, cctv);
        } else if(cctvNum == 4) {
            tmp = copyMap(map);
            checkLeft(tmp, r, c);
            checkUp(tmp, r, c);
            checkRight(tmp, r, c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkUp(tmp, r, c);
            checkRight(tmp, r, c);
            checkDown(tmp, r, c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkRight(tmp, r, c);
            checkDown(tmp, r, c);
            checkLeft(tmp ,r , c);
            dfs(cnt+1, tmp, cctv);

            tmp = copyMap(map);
            checkDown(tmp, r, c);
            checkLeft(tmp ,r , c);
            checkUp(tmp, r, c);
            dfs(cnt+1, tmp, cctv);
        } else if(cctvNum == 5) {
            tmp = copyMap(map);
            checkRight(tmp, r, c);
            checkDown(tmp, r, c);
            checkLeft(tmp ,r , c);
            checkUp(tmp, r, c);
            dfs(cnt+1, tmp, cctv);
        }
    }

    public static void checkLeft(int[][] map, int x, int y) {
        for(int i=y-1; i>=0; i--) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static void checkRight(int[][] map, int x, int y) {
        for(int i=y+1; i<M; i++) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static void checkUp(int[][] map, int x, int y) {
        for(int i=x-1; i>=0; i--) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static void checkDown(int[][] map, int x, int y) {
        for(int i=x+1; i<N; i++) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static int numZero(int[][] map) {
        int res = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) res++;
            }
        }
        return res;
    }

    public static int[][] copyMap(int[][] map) {
        int[][]copyMap = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }
}

class Point{
    int r;
    int c;
    int idx;

    Point(int r, int c, int idx) {
        this.r = r;
        this.c = c;
        this.idx = idx;
    }
}