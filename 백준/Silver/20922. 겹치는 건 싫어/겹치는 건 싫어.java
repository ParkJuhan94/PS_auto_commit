//package BOJ.Section09.P20922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section09/P20922/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 1;
		int start = 0;
		int end = 0;
		int[] numCnt = new int[100002];

		for (int i = 0; i < N; i++) {
			// 늘릴 수 있으면
			while (end < N && numCnt[nums[end]] + 1 <= K) {
				numCnt[nums[end++]]++;	// 늘리면서 카운팅
			}
			// 더이상 늘릴 수 없음
			int diff = end - start;
			answer = Math.max(answer, diff);

			// start 당기기
			numCnt[nums[start++]]--;
		}

		System.out.println(answer);
	}

}
