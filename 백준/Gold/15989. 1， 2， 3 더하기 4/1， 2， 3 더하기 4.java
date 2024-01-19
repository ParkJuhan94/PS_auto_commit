//package BOJ.Section09.P15989;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int n;

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/BOJ/Section09/P15989/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		while(T --> 0){
			n = Integer.parseInt(br.readLine());

			// dp[n][m] 은 n 을 만드는데, m으로 끝나는 경우의 수
			// 크기를 n+1 로 하면 인덱스 오류
			int[][] dp = new int[10001][4];

			dp[1][1] = 1;
			dp[2][1] = 1;
			dp[2][2] = 1;
			dp[3][1] = 1;
			dp[3][2] = 1;
			dp[3][3] = 1;

			for(int i = 4; i <= n; i++){
				dp[i][1] = dp[i - 1][1];
				dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
				dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
			}

			System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
		}
	}

}
