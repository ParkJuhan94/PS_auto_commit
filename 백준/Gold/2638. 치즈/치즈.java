//package BOJ.Section05.P2638;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int n,m;
    static boolean[][] visited;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static ArrayList<Point> meltList = new ArrayList<>();

    public static void main(String[] args) throws  IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section05/P2638/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int ans = 0;

        while(true) {

            meltList.clear();
            if(gameOver())
                break;

            // 1. 치즈 외부공기 탐색
            bfs(0,0);

            // 2. 외부공기와 2면이상 맞닿은 치즈 탐색
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] == 1 && check(i,j)) {
                        meltList.add(new Point(i,j));
                    }
                }
            }

            // 3. 치즈 녹이기
            for(Point melt : meltList) {
                map[melt.r][melt.c] = 0;
            }

//            // 4. 외부공기들 빈칸으로 갱신
//            for(int i=0; i<n; i++) {
//                for(int j=0; j<m; j++) {
//                    if(map[i][j]==2) {
//                        map[i][j]=0;
//                    }
//                }
//            }
            ans++;
        }

        System.out.println(ans);
    }

    // 2변 이상이 외부공기와 접촉했는지 반환
    public static boolean check(int x, int y) {
        int cnt = 0;
        for(int i=0; i<4; i++) {
            int nx = x+ dr[i];
            int ny = y+ dc[i];

            if(isRange(nx,ny) && map[nx][ny]==2)
                cnt++;
        }

        if(cnt>=2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRange(int x, int y) {
        if(x>=0 && y>=0 && x<n && y<m) {
            return true;
        }else{
            return false;
        }
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[n][m];
        q.add(new Point(x,y));
        visited[x][y] = true;
        map[x][y]= 2;   // 외부공기는 2

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(isRange(nr,nc) && !visited[nr][nc] && map[nr][nc] != 1) {
                    q.add(new Point(nr,nc));
                    visited[nr][nc] = true;
                    map[nr][nc] = 2;
                }
            }
        }
    }

    // 게임이 끝났는지 반환
    static boolean gameOver() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void print() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class Point {
    int r;
    int c;

    Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}