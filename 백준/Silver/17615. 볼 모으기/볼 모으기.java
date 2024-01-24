//package BOJ.Section09.P17615;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section09/P17615/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String balls = br.readLine();

		int cntR = 0;
		int cntB = 0;
		for (int i = 0; i < N; i++) {
			if (balls.charAt(i) == 'R') {
				cntR++;
			} else {
				cntB++;
			}
		}

		// 양 끝에서부터 시작하는 연속된 볼의 갯수
		int adjR = 0;
		int adjB = 0;

		int tmpAdjR = 0;
		int tmpAdjB = 0;
		for (int i = 0; i < N; i++) {
			if (balls.charAt(i) == 'R') {
				tmpAdjR++;
			} else {
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			if (balls.charAt(i) == 'B') {
				tmpAdjB++;
			} else {
				break;
			}
		}
		adjR = Math.max(adjR, tmpAdjR);
		adjB = Math.max(adjB, tmpAdjB);

		tmpAdjR = 0;
		tmpAdjB = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (balls.charAt(i) == 'R') {
				tmpAdjR++;
			} else {
				break;
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			if (balls.charAt(i) == 'B') {
				tmpAdjB++;
			} else {
				break;
			}
		}
		adjR = Math.max(adjR, tmpAdjR);
		adjB = Math.max(adjB, tmpAdjB);

		System.out.println(Math.min(cntR - adjR, cntB - adjB));
	}

}
