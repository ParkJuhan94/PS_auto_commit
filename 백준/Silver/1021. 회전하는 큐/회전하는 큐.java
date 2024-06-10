//package BOJ.Section10.P1021;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] arr;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section10/P1021/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = true;
		}

		int cur = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken()) - 1;

			int countLeftMove = countLeftMove(cur, target);
			int countRightMove = countRightMove(cur, target);

			if (countLeftMove < countRightMove) {
				ans += countLeftMove;
			} else {
				ans += countRightMove;
			}

			arr[target] = false;
			cur = findNextCur(target);
			// System.out.println("cur : " + cur);
		}

		System.out.println(ans);
	}

	// 왼쪽 이동
	static int countLeftMove(int cur, int target) {
		int res = 0;

		for(int i = cur; i < cur + N; i++) {
			if(arr[i % N]) {
				if(i % N == target) {
					break;
				}
				res++;
			}
		}

		return res;
	}

	// 오른쪽 이동
	static int countRightMove(int cur, int target) {
		int res = 0;

		for(int i = cur; i > cur - N; i--) {
			if(arr[(i + N) % N]) {
				if((i + N) % N == target) {
					break;
				}
				res++;
			}
		}

		return res;
	}

	// 현재 위치에서 다음 true인 위치 찾기
	static int findNextCur(int cur) {
		for (int i = cur; i < cur + N; i++) {
			if (arr[i % N]) {
				return i % N;
			}
		}
		return cur;  // 모든 요소가 false인 경우 현재 위치 반환
	}
}
