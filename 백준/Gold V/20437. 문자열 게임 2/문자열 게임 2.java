//package BOJ.Section09.P20437;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section09/P20437/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		while (T-- > 0) {
			String inputStr = br.readLine();
			int K = Integer.parseInt(br.readLine());

			// 각 알파벳이 위치한 인덱스를 모두 ArrayList로 저장한다
			List<Integer>[] alphabet = new ArrayList[26];
			for (int i = 0; i < alphabet.length; i++) {
				alphabet[i] = new ArrayList<>();
			}

			for (int i = 0; i < inputStr.length(); i++) {
				char c = inputStr.charAt(i);
				alphabet[c - 'a'].add(i);
			}

			int minLen = Integer.MAX_VALUE;
			int maxLen = Integer.MIN_VALUE;

			for (int i = 0; i < 26; i++) {
				List<Integer> alphabetPositions = alphabet[i];
				int countAlpha = alphabetPositions.size();

				if (countAlpha < K) {	// K개 이상 포함해야하니까
					continue;
				}

				// 어떤 문자를 정확히 K개를 포함하는 모든 연속된 문자열을 탐색
				for (int j = 0; j <= countAlpha - K; j++) {
					// 어떤 문자를 K개만 포함하는 문자열
					int len = alphabetPositions.get(j + K - 1) - alphabetPositions.get(j) + 1;
					
					minLen = Math.min(minLen, len);
					maxLen = Math.max(maxLen, len);
				}
			}

			if (minLen == Integer.MAX_VALUE && maxLen == Integer.MIN_VALUE) {
				answer.append("-1\n");
			} else {
				answer.append(minLen + " " + maxLen + "\n");
			}
		}

		System.out.println(answer);
	}

}
