//package BOJ.Section10.P17266;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section10/P17266/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(N);  // 끝 위치

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}

		int maxHeight = 0;
		int prev = 0;

		for (int i = 0; i < M + 1; i++) {
			Integer cur = pq.poll();
			
			if (i == 0 || i == M) {
				if (cur - prev > maxHeight) {
					maxHeight = cur - prev;
				}
			} else {
				if ((cur - prev + 1) / 2 > maxHeight) {
					maxHeight = (cur - prev + 1) / 2;
				}
			}

			prev = cur;
		}

		System.out.println(maxHeight);
	}

}
