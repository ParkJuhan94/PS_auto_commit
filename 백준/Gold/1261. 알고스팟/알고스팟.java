//package WEEK00.P1261;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int INF = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK00/P1261/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ch = new int[N][M];
        ans = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j) - '0';
                ch[i][j] = INF;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        ch[0][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int row = node.row;
            int col = node.col;
            int count = node.count;

            if (row == N - 1 && col == M - 1) { // 끝에 도달하면
                System.out.println(count);
                break;
            }

            if (count > ch[row][col]) { // 최솟값이 아니니까 넘어가
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = row + dr[i];
                int ny = col + dc[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 1을(벽) 더하면 부순게 되는거야
                int nextCount = count + map[nx][ny];    

                // 최솟값보다 작을때만 갱신하고 add
                if (nextCount < ch[nx][ny]) {
                    ch[nx][ny] = nextCount;
                    pq.offer(new Node(nx, ny, nextCount));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int row;
    int col;
    int count;    // 해당 노드까지 부순 벽의 갯수

    public Node(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.count, other.count);
    }
}