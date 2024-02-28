//package BOJ.Section09.P5972;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<int[]> adj[];
	static int dist[];

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/BOJ/Section09/P5972/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		dist = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new int[] {v, w});
			adj[v].add(new int[] {u, w});
		}

		dijkstra();

		System.out.println(dist[N]);
	}

	private static void dijkstra() {
		PriorityQueue<Route> pq = new PriorityQueue<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		pq.offer(new Route(1, 0));

		while(!pq.isEmpty()) {
			Route curr = pq.poll();
			if(dist[curr.v] < curr.w) continue;
			for(int[] next : adj[curr.v]) {
				if (dist[next[0]] > curr.w + next[1]) {
					dist[next[0]] = curr.w + next[1];
					pq.offer(new Route(next[0], dist[next[0]]));
				}
			}
		}
	}

	public static class Route implements Comparable<Route>{
		int v, w;
		public Route(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Route o) {
			return this.w - o.w;
		}
	}
}
