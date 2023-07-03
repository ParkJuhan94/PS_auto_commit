//package BOJ.Section04.P1103;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        //    System.setIn(new FileInputStream("src/BOJ/Section04/P1929/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        boolean[] visit = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (!visit[j]) {
                    cnt++;
                    visit[j] = true;
                }

                if (cnt == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }

}