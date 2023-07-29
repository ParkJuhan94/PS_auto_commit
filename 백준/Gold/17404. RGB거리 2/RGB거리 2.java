//package BOJ.Section06.P17404;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section06/P17404/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[1000][3];
        dp = new int[1000][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;
        // 0번째 집을 어떤색으로 칠하느냐에 따라서 -> 3가지 최솟값이 후보가 된다
        for (int i = 0; i < 3; i++) {
            // 우선 0번째 집을 현재 i값과 같을 때 해당 집은 원 배열의 값으로
            // 나머지는 최소 비용이 나올 수 없는 값으로 초기화 한다.
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[0][j] = arr[0][i];
                } else {
                    dp[0][j] = 1000 * 1000 + 1;
                }
            }

            // 모든 집을 칠하는 경우를 구해나간다.
            for (int j = 1; j < N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }

            // n-1번째까지 구해진 값 중 최소 비용의 값을 구한다.
            for (int j = 0; j < 3; j++) {
                // 0번째와 N-1번째가 같은 경우는 애초에 Count X
                if (i == j) continue;
                result = Math.min(result, dp[N - 1][j]);
            }
        }

        System.out.println(result);
    }
}
