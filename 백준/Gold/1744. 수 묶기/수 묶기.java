//package WEEK000.P1744;

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
    static long ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK000/P1744/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 원소가 하나일 때
        if(N == 1){
            System.out.println(numbers[0]);
            return;
        }

        Arrays.sort(numbers);

        int sum = 0;
        int i = 0;

        // 음수
        while (i < N && numbers[i] <= 0 && i + 1 < N && numbers[i + 1] <= 0) {
            sum += numbers[i] * numbers[i + 1];
            i += 2;
        }

        // 하나 남았으면 쓸어담기
        while (i < N && numbers[i] <= 0) {
            if(numbers[i + 1] == 0){
                break;
            }
            sum += numbers[i];
            i++;
        }

        // 양수
        i = N - 1;

        while (i >= 0 && numbers[i] > 1 && i - 1 >= 0 && numbers[i - 1] > 1) {
            sum += numbers[i] * numbers[i - 1];
            i -= 2;
        }

        while (i >= 0 && numbers[i] > 0) {
            sum += numbers[i];
            i--;
        }

        System.out.println(sum);
    }

}