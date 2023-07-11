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
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) throws  IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section05/P2638/input.txt"));
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

            list.clear();
            if(gameOver())
                break;

            // 1. 치즈 외부공기 탐색
            bfs(0,0);

            // 2. 외부공기와 2면이상 맞닿은 치즈 탐색
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j]==1 && check(i,j)) {
                        list.add(new Node(i,j));
                    }
                }
            }

            // 3. 녹아야 할 예정인 치즈 녹이기
            for(Node a: list) {
                map[a.x][a.y]= 0;
            }

            // 4. 외부치즈들 빈칸으로 갱신
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j]==2) {
                        map[i][j]=0;
                    }
                }
            }
            ans++;
        }

        System.out.println(ans);
    }

    public static boolean check(int x, int y) {

        int cnt = 0;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(isRange(nx,ny) && map[nx][ny]==2) {
                cnt++;
            }
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
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[n][m];
        q.add(new Node(x,y));
        visited[x][y] = true;
        map[x][y]= 2;
        while(!q.isEmpty()) {
            Node a = q.poll();

            for(int i=0; i<4; i++) {
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(isRange(nx,ny) && !visited[nx][ny] && map[nx][ny]==0) {
                    q.add(new Node(nx,ny));
                    visited[nx][ny]=  true;
                    map[nx][ny] = 2;
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

class Node{
    int x,y;
    Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}