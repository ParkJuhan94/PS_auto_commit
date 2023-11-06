//package BOJ.Section08.P17484;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Integer> list = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section08/P17484/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // start
        for(int col = 0; col < M; col++){
            list.add(map[0][col]);
            dfs(0, col, 100, map[0][col]);
        }

        System.out.println(answer);
    }

    static void dfs(int depth, int col, int prevDir, int sum) {
        if (depth == N - 1) {
            if (sum < answer) {
                answer = sum;
            }
//            System.out.println(list);
//            list = new ArrayList<>();
            return;
        }

        for (int dir = -1; dir <= 1; dir++) {

            int nextCol = (col + dir);
            if (0 <= nextCol && nextCol < M && dir != prevDir) {
//                System.out.println(map[depth][col] + " -> " + map[depth + 1][nextCol]);
//                list.add(map[depth + 1][nextCol]);
                dfs(depth + 1, nextCol, dir, sum + map[depth + 1][nextCol]);
            }
        }
    }
}
