//package BOJ.Section10.P20040;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] parents;

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/BOJ/Section10/P20040/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		boolean cycle = false;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);

			if (find(a) == find(b)) {
				cycle = true;
				System.out.println(i + 1);
				return;
			} else {
				union(a, b);
			}
		}

		System.out.println(0);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		// 더 작은 번호의 노드를 부모로 해야한다면
		if (x <= y)
			parents[y] = x;
		else
			parents[x] = y;
		return true;
	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return find(parents[x]);
	}
}
