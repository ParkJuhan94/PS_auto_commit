//package WEEK000.P1911;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK000/P1911/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long[][] roads = new long[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken()); // 웅덩이의 시작 위치
            roads[i][1] = Integer.parseInt(st.nextToken()); // 웅덩이의 끝 위치
        }

        Arrays.sort(roads, (a, b) -> Math.toIntExact(a[0] - b[0])); // 좌표를 기준으로 오름차순 정렬

        int count = 0;  // 보수 횟수
        long curPos = 0; // 현재 위치

        for(int i = 0; i < N; i++){
            long start = roads[i][0];   // 흙길의 시작 좌표
            long end = roads[i][1];     // 흙길의 끝 좌표

            // 포장되지 않은 구간 계산
            long diff = end - Math.max(start, curPos);

            // 포장되지 않은 구간이 보수 가능한 길이보다 큰 경우
            if (diff > 0) {
                //System.out.print(curPos + " 현재 위치애서 널빤지 놓기");

                long repairs = (diff + M - 1) / M; // 보수 횟수 계산
                count += repairs;       // 보수 횟수 추가
                curPos = Math.max(start, curPos) + repairs * M; // 현재 위치 업데이트

                //System.out.println(" : " + repairs + "개");
            }
        }

        System.out.println(count);
    }

}