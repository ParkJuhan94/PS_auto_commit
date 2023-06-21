//package WEEK00.P4485;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dist;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/WEEK00/P4485/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int t = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0){
                break;
            }
            map = new int[N][N];
            dist = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, map[0][0]));
            dist[0][0] = map[0][0];

            while(!pq.isEmpty()){
                Node cur = pq.poll();
                int row = cur.row;
                int col = cur.col;
                int count = cur.count;

                if(row == N - 1 && col == N - 1){
                    System.out.println("Problem " + t + ": " + dist[row][col]);
                    break;
                }

                if(count > dist[row][col]){
                    continue;
                }

                for(int i = 0; i < 4; i++){
                    int nr = row + dr[i];
                    int nc = col + dc[i];

                    if(0 <= nr && nr < N && 0 <= nc && nc < N){
                        int nextCount = count + map[nr][nc];

                        if(nextCount < dist[nr][nc]){
                            dist[nr][nc] = nextCount;
                            pq.add(new Node(nr, nc, nextCount));
                        }
                    }
                }
            }

            t++;
        }
    }

}

class Node implements Comparable<Node> {
    int row;
    int col;
    int count;

    public Node(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        return count - o.count;
    }
}