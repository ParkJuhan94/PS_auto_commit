//package BOJ.Section10.P10431;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int P, T;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section10/P10431/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		P = Integer.parseInt(st.nextToken());
		int[] students = new int[20];

		while(P-- > 0){
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());

			for (int i = 0; i < 20; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}

			int ans = 0;
			for (int i = 1; i < 20; i++) {
				for (int j = 0; j < i; j++) {
					if(students[j] > students[i]){
						ans++;
					}
				}
			}

			System.out.println((T + " " + ans));
		}
	}

}
