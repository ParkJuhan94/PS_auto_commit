//package BOJ.Section08.P11501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int T;
	static long answer = 0;
	static int[] prices;
	static long max = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/BOJ/Section08/P11501/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			prices = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			max = 0;
			answer = 0;
			for (int i = N - 1; i >= 0; i--) {
                if(prices[i] > max){
					max = prices[i];
				}else{
					answer += max - prices[i];
				}
			}

			sb.append(answer + "\n");
		}

		System.out.println(sb.toString());
	}

}
