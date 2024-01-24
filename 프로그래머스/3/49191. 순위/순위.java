

import java.util.ArrayList;

class Solution {
	public int solution(int n, int[][] results) {
		int answer = n;
		long INF = Integer.MAX_VALUE;
		ArrayList<Long>[] graph = new ArrayList[n];

		/**
		 * 플로이드-와샬
		 * 모든 정점에서 다른 모든 정점으로 가는 최단 거리를 구하는 알고리즘
		 */

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (i == j) {
					graph[i].add(0L);
				} else {
					graph[i].add(INF);
				}
			}
		}

		// 입력값 세팅
		for (int[] result : results) {
			graph[result[0] - 1].set(result[1] - 1, 1L);
		}

		// i에서 j로 갈 수 있는지 여부를 파악하는데, k를 거쳐서 갈 수 있는지를 확인
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신 : 이 문제에서는 중요 x
					graph[i].set(j, Math.min(graph[i].get(j), graph[i].get(k) + graph[k].get(j)));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}

				if (graph[i].get(j) == INF && graph[j].get(i) == INF) {
					answer--;
					break;
				}
			}
		}

		return answer;
	}
}
