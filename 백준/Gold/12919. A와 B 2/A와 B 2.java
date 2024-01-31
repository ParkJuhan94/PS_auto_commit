//package BOJ.Section09.P12919;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static String S, T;
	static int answer = 0;
	static Set<String> hashset = new HashSet<>();

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/BOJ/Section09/P12919/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		T = br.readLine();

		dfs(T);

		System.out.println(answer);
	}

	static void dfs(String str) {
		// if(hashset.contains(str)){
		// 	return;
		// }
		// hashset.add(str);

		//System.out.println(str);
		if (str.length() <= S.length()) {
			if(str.equals(S)){
				answer = 1;
			}
			return;
		}

		if(str.charAt(str.length() - 1) == 'A'){
			dfs(convertA(str));
		}
		
		if(str.charAt(0) == 'B'){
			dfs(convertB(str));
		}
	}

	// 맨 뒤가 A라면 A를 빼고
	static String convertA(String str) {
		return str.substring(0, str.length() - 1);
	}

	// 맨 앞이 B라면 B를 빼고 뒤집기
	static String convertB(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring(1));
		return sb.reverse().toString();
	}
}
