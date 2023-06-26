//package WEEK000.P15650;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;
    static int[] selected; // 선택한 숫자를 저장할 배열

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK000/P15650/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        ch = new int[N + 1 ];

        combination(1, 0); // 1부터 시작하여 조합 생성
    }

    static void combination(int start, int count) {
        if (count == M) { // M개의 숫자를 선택한 경우
            for (int num : selected) {
                System.out.print(num + " "); // 선택한 숫자 출력
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[count] = i; // 현재 숫자 선택
            combination(i + 1, count + 1); // 다음 숫자 선택
        }
    }
}