//package BOJ.Section07.P12100;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
        import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;
    private static int[][] tempMap;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[] direct;
    private static boolean[][] ch;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section07/P12100/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(reader.readLine());

        map = new int[N + 1][N + 1];
        direct = new int[5];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 5);
        System.out.println(max);
    }

    private static void dfs(int depth, int end) {

        if (depth == end) {
            confirm();
            
        } else {
            for (int i=0; i<4; i++) {
                direct[depth] = i;
                dfs(depth+1, end);
            }
        }
    }

    private static void confirm() {

        tempMap = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            tempMap[i] = map[i].clone();
        }

        for (int d=0; d<direct.length; d++) {
            ch = new boolean[N +1][N +1];

            if (direct[d] == 0) { // 상
                for (int i = 1; i<= N; i++) {
                    for (int j = 1; j<= N; j++) {
                        move(i,j,direct[d]);
                    }
                }
            } else if (direct[d] == 2) { // 하
                for (int i = N; i>=1; i--) {
                    for (int j = 1; j<= N; j++) {
                        move(i,j,direct[d]);
                    }
                }
            } else if (direct[d] == 1) { // 우
                for (int i = N; i>=1; i--) {
                    for (int j = 1; j<= N; j++) {
                        //오른쪽부터
                        move(j,i,direct[d]);
                    }
                }
            } else { // 좌
                for (int i = 1; i<= N; i++) {
                    for (int j = 1; j<= N; j++) {
                        //왼쪽부터
                        move(j,i,direct[d]);
                    }
                }
            }
        }

        for (int i = 1; i<= N; i++) {
            for (int j = 1; j<= N; j++) {
                if (tempMap[i][j] > max) {
                    max = tempMap[i][j];
                }
            }
        }

    }//confirm

    private static void move(int x, int y, int dir) {

        if (tempMap[x][y] == 0) return;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || ny < 1 || nx > N || ny > N) {
                return;
            }
            if (ch[nx][ny]) {
                return;
            }
            
            if (tempMap[nx][ny] == tempMap[x][y]) {
                // 같을 때 합친다
                ch[nx][ny] = true;
                tempMap[nx][ny] *= 2;
                tempMap[x][y] = 0;
                return;
            } else if (tempMap[nx][ny] != 0) {
                // 못합침
                return;
            }

            tempMap[nx][ny] = tempMap[x][y];
            tempMap[x][y] = 0;
            x = nx;
            y = ny;

        }

    } // move end
}
