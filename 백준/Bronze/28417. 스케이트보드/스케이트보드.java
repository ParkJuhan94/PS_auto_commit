//package BOJ.Section06.P28417;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section06/P28417/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[][] scores1 = new int[N][2];
        int[][] scores2 = new int[N][5];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                scores1[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < 5; j++){
                scores2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        // 점수 구하기
        for(int i = 0; i < N; i++){
            int sum = 0;
            sum += Math.max(scores1[i][0], scores1[i][1]);

            Arrays.sort(scores2[i]);
            sum += scores2[i][4];
            sum += scores2[i][3];

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}