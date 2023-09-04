//package BOJ.Section07.P2412;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N = 50000, x = 1_000_000, y = 200,000
    static int N, T;
    static ArrayList<Integer>[] points; // y 구간별로 저장(x보다 작으니까 메모리 작게)
    static int ans = -1;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section07/P2412/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        points = new ArrayList[200_001];
        for(int i = 0; i < 200001; i++){
            points[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[y].add(x);
        }

        // 구간마다 오름차순 정렬
        for(int i = 0; i < 200001; i++){
            Collections.sort(points[i]);
        }

        bfs();

        System.out.println(ans);
    }

    static void bfs()
    {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.y == T){
               ans = cur.cnt;
               return;
            }

            // 갈수있는 홈 탐색
            for(int y = cur.y - 2; y <= cur.y + 2; y++)
            {
                if(0 <= y && y <= 200000)
                {
                    for(int i = 0; i < points[y].size(); i++)
                    {
                        if(Math.abs(points[y].get(i) - cur.x) <= 2)
                        {
                            int x = points[y].get(i);

                            q.add(new Point(x, y, cur.cnt + 1));
                            //System.out.println(x + ", " + y + ", " + (cur.cnt + 1));

                            points[y].remove(i);
                            i--;    // remove 했으니 인덱스 조정
                        }
                    }
                }
            }
        }
    }

}

class Point{
    int x;
    int y;
    int cnt = 0;

    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}