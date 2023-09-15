//package BOJ.Section07.P17144;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] map;
    // 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다
    static int[][] tmpMap;
    // robot 의 0번이 위쪽 순환, 1번이 아래쪽 순환
    static ArrayList<Point> robots = new ArrayList<>();
    // 시계 반대 방향 순서
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section07/P17144/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int r = 0 ; r < R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C; c++)
            {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == -1){
                    robots.add(new Point(r, c));
                }
            }
        }

        Sol();
    }

    static void Sol()
    {
//        print();

        while(T --> 0)
        {
            // 미세먼지 퍼뜨리기
            tmpMap = new int[R][C];

            for(int r = 0; r < R; r++){
                for(int c = 0; c < C; c++)
                {
                    spread(r, c);
                }
            }

            for(int r = 0; r < R; r++){
                for(int c = 0; c < C; c++){
                    map[r][c] += tmpMap[r][c];
                }
            }

//            print();

            // 공기청정기 돌리기
            // 1. 위쪽
            Point robot = robots.get(0);
            topClean(robot);

            // 2. 아래쪽
            robot = robots.get(1);
            bottomClean(robot);

//            print();
        }

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++)
            {
                if(map[r][c] != -1){
                    answer += map[r][c];
                }
            }
        }

        System.out.println(answer);
    }

    // 해당 위치의 미세먼지를 인근에 퍼뜨리기
    static void spread(int r, int c)
    {
        int num = 0;
        ArrayList<Point> spreadSapces = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(0 <= nr && nr < R && 0 <= nc && nc < C && map[nr][nc] != -1){
                spreadSapces.add(new Point(nr, nc));
                num++;
            }
        }

        int unit = map[r][c] / 5;   // 퍼뜨릴 먼지의 단위
        map[r][c] -= unit * num;

        for(int i = 0; i < spreadSapces.size(); i++){
            Point cur = spreadSapces.get(i);
            tmpMap[cur.r][cur.c] += unit;
        }
    }

    static void topClean(Point robot)
    {
        for(int r = robot.r; r >= 1; r--){
            map[r][0] = map[r - 1][0];
        }
        map[robot.r][robot.c] = -1; // 먼지 제거

        for(int c = 0; c <= C - 2; c++)
        {
            map[0][c] = map[0][c + 1];
        }

        for(int r = 0; r <= robot.r - 1; r++){
            map[r][C - 1] = map[r + 1][C - 1];
        }

        for(int c = C - 1; c >= 2; c--)
        {
            map[robot.r][c] = map[robot.r][c - 1];
        }
        map[robot.r][1] = 0;    // 공기청정기가 밀어서 0일 수 밖에 없음
    }

    static void bottomClean(Point robot)
    {
        for(int r = robot.r; r <= R - 2; r++){
            map[r][0] = map[r + 1][0];
        }
        map[robot.r][robot.c] = -1; // 먼지 제거

        for(int c = 0; c <= C - 2; c++)
        {
            map[R - 1][c] = map[R - 1][c + 1];
        }

        for(int r = R - 1; r >= robot.r + 1; r--){
            map[r][C - 1] = map[r - 1][C - 1];
        }

        for(int c = C - 1; c >= 2; c--)
        {
            map[robot.r][c] = map[robot.r][c - 1];
        }
        map[robot.r][1] = 0;    // 공기청정기가 밀어서 0일 수 밖에 없음
    }

    static void print(){
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println();
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
