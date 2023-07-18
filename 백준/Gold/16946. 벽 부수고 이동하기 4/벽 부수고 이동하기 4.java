//package BOJ.Section05.P16946;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static Point[][] ans;
    static int[][] ch;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section05/P16946/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ch = new int[n][m];
        ans = new Point[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                ans[i][j] = new Point(0,0);
            }
        }

        makeGroup();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    check(i,j);
                }else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    static void makeGroup(){
        int groupIdx = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0 && ch[i][j] == 0){
                    bfs(i, j, groupIdx);
                    groupIdx++;
                }
            }
        }
    }

    // 그룹을 만들때 0 퍼뜨리기
    static void bfs(int r, int c, int groupIdx){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        ch[r][c] = 1;
        int cnt = 1;    // 그룹내 0의 갯수

        Queue<Point> tempQ = new LinkedList<>();
        tempQ.add(new Point(r, c));

        // 셋팅
        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nr = cur.row + dr[i];
                int nc = cur.col + dc[i];

                if(0 <= nr && nr < n && 0 <= nc && nc < m){
                    if(ch[nr][nc] == 0 && map[nr][nc] == 0){
                        q.add(new Point(nr, nc));
                        ch[nr][nc] = 1;

                        tempQ.add(new Point(nr, nc));
                        cnt++;
                    }
                }
            }
        }

        // 셋팅한걸로 저장
        while(!tempQ.isEmpty()){
            Point cur = tempQ.poll();

            ans[cur.row][cur.col].row = cnt;        // 0의 갯수
            ans[cur.row][cur.col].col = groupIdx;   // 그룹 번호 지정
        }

    }


    // 네방향 탐색
    public static void check(int r, int c) {
        HashSet<Integer> dict = new HashSet<>();
        int cnt = 1;

        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 0 이면서 다른 그룹이면 더해줌
            if(0 <= nr && nr < n && 0 <= nc && nc < m){
                if(map[nr][nc] == 0 && !dict.contains(ans[nr][nc].col)) {
                    cnt += ans[nr][nc].row;
                    dict.add(ans[nr][nc].col);
                }
            }
        }

        // 문제조건
        sb.append(cnt%10);
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}