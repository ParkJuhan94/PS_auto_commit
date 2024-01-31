//package BOJ.Section09.P20055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] belt;
	static boolean[] robots;    // 벨트 칸마다 로봇이 존재하는지
	static int answer = 0;
	static int left, right;    // 올리는 지점, 내리는 지점
	static int size = 0;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section09/P20055/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		size = 2 * N;
		belt = new int[size];
		robots = new boolean[size];
		left = 0;
		right = N;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		while (K > 0) {
			rotateBelt();
			rotateRobot();
			newRobot();
			answer++;
		}

		System.out.println(answer);
	}

	public static void rotateBelt() {
		// 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
		left = (size + left - 1) % size;
		right = (size + right - 1) % size;

		for (int i = N - 2; i >= 0; i--) {
			if (robots[i]) {
				robots[i] = false;
				if (i + 1 < N - 1)    // 내리는 지점 전이면
					robots[i + 1] = true;
			}
		}
	}

	public static void rotateRobot() {
		// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
		for (int i = N - 2; i >= 0; i--) {
			if (robots[i]) {
				int next = left + i + 1;
				if (next >= size) {
					next -= size;
				}

				if (!robots[i + 1] && belt[next] >= 1) {
					robots[i] = false;
					if (i < N - 2) {
						robots[i + 1] = true;
					}
					belt[next]--;
					if (belt[next] == 0) {
						K--;
					}
				}
			}
		}
	}

	public static void newRobot() {
		// 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
		if (!robots[0] && belt[left] != 0) {
			robots[0] = true;
			belt[left]--;

			if (belt[left] == 0) {
				K--;
			}
		}
	}
}
