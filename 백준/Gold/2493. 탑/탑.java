//package BOJ.Section09.P2493;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section09/P2493/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<int[]> stack = new Stack<>();	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int curTopHeight = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				sb.append(0 + " ");
			} else {
				while (true) {
					// 0번 인덱스는 위치, 1번 인덱스는 높이
					int[] preTop = stack.peek();
					int preTopIdx = preTop[0];
					int preTopHeight = preTop[1];
					
					if (preTopHeight > curTopHeight) {
						sb.append(preTopIdx + " ");
						break;
					} else {
						stack.pop();
					}

					if (stack.isEmpty()) {
						sb.append(0 + " ");
						break;
					}
				}
			}
			
			stack.push(new int[] {i + 1, curTopHeight});
		}
		
		System.out.println(sb.toString());
	}

}
