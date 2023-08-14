//package BOJ.Section07.P1758;

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
    //    System.setIn(new FileInputStream("src/BOJ/Section07/P1758/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Integer[] tips = new Integer[N];

        for(int i = 0; i < N; i++){
            tips[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tips, Collections.reverseOrder());

        long ans = 0;
        for(int i = 1; i <= N; i++){
            int tip = tips[i - 1] - (i - 1);

            if(tip > 0) {
                ans += tip;
            }
        }

        System.out.println(ans);
    }

}