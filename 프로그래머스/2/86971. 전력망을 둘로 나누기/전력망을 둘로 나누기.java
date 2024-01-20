import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

	int n;
	int[][] wires;
	ArrayList<Integer>[] adj;
	boolean[] visited;
	int minDiff;

	public int solution(int n, int[][] wires) {
		this.n = n;
		this.wires = wires;

		bfs();

		return minDiff;
	}

	void bfs() {

		minDiff = n;

		// 와이어 돌아가면서 자르기
		for (int wireIdx = 0; wireIdx < wires.length; wireIdx++) {
			makeAdj(wireIdx);

			// 1번탑과 연결된 탑 개수 세기
			Queue<Integer> q = new LinkedList<>();
			q.add(1);
			visited = new boolean[n + 1];
			visited[1] = true;

			while (!q.isEmpty()) {
				Integer curTop = q.poll();

				for (int i = 0; i < adj[curTop].size(); i++) {
					Integer nextTop = adj[curTop].get(i);
					if (!visited[nextTop]) {
						q.add(nextTop);
						visited[nextTop] = true;
					}
				}
			}

			int adjTopNum = 0;

			for (int topIdx = 1; topIdx <= n; topIdx++) {
				if (visited[topIdx]) {
					adjTopNum++;
				}
			}

			int diff = Math.abs(adjTopNum - (n - adjTopNum));
			minDiff = Math.min(minDiff, diff);
		}
	}

	// 끊은 전선을 고려해서 연결 관계 만들기
	void makeAdj(int wireIdx) {
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < wires.length; i++) {
			if (i == wireIdx) {
				continue;
			}

			int v1 = wires[i][0];
			int v2 = wires[i][1];
			adj[v1].add(v2);
			adj[v2].add(v1);
		}
	}

}