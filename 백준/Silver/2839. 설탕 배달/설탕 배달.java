//package BOJ.Section10.P2839;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/BOJ/Section10/P2839/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		if (N >= 3) {
			dp[3] = 1;
		}

		if (N >= 5) {
			dp[5] = 1;
		}

		for (int i = 6; i <= N; i++) {
			int from3 = Integer.MAX_VALUE;
			int from5 = Integer.MAX_VALUE;

			if (dp[i - 3] != 0) {
				from3 = dp[i - 3] + 1;
			}
			if (dp[i - 5] != 0) {
				from5 = dp[i - 5] + 1;
			}

			if (from3 != Integer.MAX_VALUE || from5 != Integer.MAX_VALUE) {
				dp[i] = Math.min(from3, from5);
			}
		}

		if (dp[N] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}

}
