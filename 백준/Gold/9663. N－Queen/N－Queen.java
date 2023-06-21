//package WEEK00.P9663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    static int count = 0;
    static int[] columns;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK00/P9663/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        columns = new int[N + 1]; // 각 행마다 퀸의 열 위치를 저장하는 배열

        // 첫 번째 행부터 시작하여 퀸을 놓을 수 있는 모든 경우를 탐색
        for (int i = 1; i <= N; i++) {
            columns[1] = i; // 첫 번째 행의 i번째 열에 퀸을 놓음
            backtrack(1);
        }

        System.out.println(count);
    }
    
    private static void backtrack(int row) {
        if (row == N) { // 마지막 행까지 퀸을 놓은 경우
            count++; // 경우의 수를 증가시킴
        } else {
            // 다음 행의 각 열에 퀸을 놓을 수 있는지 확인하고 재귀 호출
            for (int i = 1; i <= N; i++) {
                columns[row + 1] = i; // 다음 행의 i번째 열에 퀸을 놓음
                if (isPossible(row + 1)) { // 퀸을 놓을 수 있는 경우
                    backtrack(row + 1); // 다음 행으로 이동
                }
            }
        }
    }

    // 해당 위치에 퀸을 놓을 수 있는지 확인하는 함수
    private static boolean isPossible(int row) {
        for (int i = 1; i < row; i++) {
            // 같은 열에 퀸이 있는 경우 또는 대각선 방향에 퀸이 있는 경우
            if (columns[i] == columns[row] || Math.abs(columns[i] - columns[row]) == Math.abs(i - row)) {
                return false; // 퀸을 놓을 수 없음
            }
        }
        return true; // 퀸을 놓을 수 있음
    }

}