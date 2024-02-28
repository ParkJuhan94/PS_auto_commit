

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] originBulbs;
	static int[] targetBulbs;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section09/P2138/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		originBulbs = new int[n];
		targetBulbs = new int[n];

		int[] caseDidnt = new int[n];    // 시작 스위치 안 누름
		int[] caseDid = new int[n];        // 시작 스위치 누름

		String input = br.readLine();
		for (int i = 0; i < n; i++) {
			originBulbs[i] = input.charAt(i) - '0';
			caseDidnt[i] = input.charAt(i) - '0';
			caseDid[i] = input.charAt(i) - '0';
		}

		input = br.readLine();
		for (int i = 0; i < n; i++) {
			targetBulbs[i] = input.charAt(i) - '0';
		}

		int countDidnt = 0;
		int countDid = 1;

		for (int i = 0; i < n; i++) {
			// 제일 첫 위치에서는 caseDid 배열의 경우 0번째와 1번째를 변경하고 시작한다.
			if (i == 0) {
				caseDid[i] = caseDid[i] ^ 1;
				caseDid[i + 1] = caseDid[i + 1] ^ 1;
			} else {
				// 현재 caseDidnt 배열의 비교 위치가 만들고자 하는 상태의 위치와 다른 상태라면
				if (caseDidnt[i - 1] != targetBulbs[i - 1]) {
					// 스위치를 누른다.
					change(caseDidnt, i);
					countDidnt++;
				}

				// 마지막에 도달했는데 값이 다르다면 최대값으로 변경
				if (i == n - 1 && caseDidnt[i] != targetBulbs[i]) {
					countDidnt = Integer.MAX_VALUE;
				}

				
				
				// 현재 caseDid 배열의 비교 위치가 만들고자 하는 상태의 위치와 다른 상태라면
				if (caseDid[i - 1] != targetBulbs[i - 1]) {
					// 스위치를 누른다.
					change(caseDid, i);
					countDid++;
				}

				// 마지막에 도달했는데 값이 다르다면 최대값으로 변경
				if (i == n - 1 && caseDid[i] != targetBulbs[i]) {
					countDid = Integer.MAX_VALUE;
				}
			}
		}

		// 둘 다 최대값이라면 변경이 불가능한 경우이므로 -1을 출력
		if (countDidnt == Integer.MAX_VALUE && countDid == Integer.MAX_VALUE) {
			System.out.println(-1);
			// 그 외에는 더 작은 값을 출력
		} else {
			System.out.println(Math.min(countDidnt, countDid));
		}
	}

	private static void change(int[] arr, int i) {
		// 마지막 부분이라면 자신 이후는 변환이 불가하다.
		if (i == n - 1) {
			arr[i - 1] = arr[i - 1] ^ 1;
			arr[i] = arr[i] ^ 1;
		} else {
			arr[i - 1] = arr[i - 1] ^ 1;
			arr[i] = arr[i] ^ 1;
			arr[i + 1] = originBulbs[i + 1] ^ 1;
		}
	}
}
