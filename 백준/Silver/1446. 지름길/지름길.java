package BOJ.Section09.P1446;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, D;
	static Road[] roads;
	static int answer;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/BOJ/Section09/P1446/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		roads = new Road[N];
		answer = D;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			Road road = new Road(start, end, len);
			roads[i] = road;
		}

		Arrays.sort(roads);

		dfs(0, 0);

		System.out.println(answer);
	}

	static void dfs(int cur, int driving) {
		System.out.println("dfs(" + cur + ", " + driving + ")");
		if (cur == D) {
			answer = Math.min(answer, driving);
			return;
		}

		if (cur > D) {
			return;
		}

		for (int i = 0; i < N; i++) {
			Road road = roads[i];

			// 지름길 가기
			if (cur == road.start) {
				dfs(road.end, driving + road.len);
			}
		}

		// 지름길 안 가기
		int next = nextRoadStart(cur);
		dfs(next, driving + (next - cur));
	}

	static int nextRoadStart(int cur) {
		for (int i = 0; i < N; i++) {
			if (roads[i].start > cur) {
				return roads[i].start;
			}
		}
		return cur + 1;
	}
}

class Road implements Comparable<Road> {
	int start;
	int end;
	int len;

	public Road(int start, int end, int len) {
		this.start = start;
		this.end = end;
		this.len = len;
	}

	@Override
	public int compareTo(Road o) {
		return start - o.start;
	}
}
