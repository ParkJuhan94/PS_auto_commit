import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] wantStudents;
	static boolean[] visited;
	static boolean[] finished;
	static int count;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section10/P9466/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			wantStudents = new int[N + 1];
			visited = new boolean[N + 1];
			finished = new boolean[N + 1];
			count = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				wantStudents[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}

			System.out.println(N - count);
		}
	}

	static void dfs(int start) {
		visited[start] = true;
		int next = wantStudents[start];

		if (!visited[next]) {
			dfs(next);
		} else if (!finished[next]) {
			for (int i = next; i != start; i = wantStudents[i]) {
				count++;
			}
			count++;
		}

		finished[start] = true;
	}
}
