//package BOJ.Section05.P1052;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section05/P1052/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N <= K) {
            System.out.println(0);
            return;
        }

        int ans = 0;
        while (Integer.bitCount(N) > K) {
            int lowestBit = N & -N; // 가장 낮은 비트(가장 오른쪽에 있는 1)의 값 구하기
            ans += lowestBit;
            N += lowestBit; // N의 가장 낮은 비트를 하나씩 제거해가며 K개의 1을 만들어냄
        }

        System.out.println(ans);
    }
}
