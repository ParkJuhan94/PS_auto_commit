import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
	private int answer;
	private final List<List<Integer>> GRAPH = new LinkedList<>();

	public int solution(int[] info, int[][] edges) {
		answer = 0;
		for (int i = 0; i < info.length; i++) {
			GRAPH.add(new LinkedList<>());
		}

		for (int[] edge : edges) {
			GRAPH.get(edge[0]).add(edge[1]);
		}

		final List<Integer> next = new LinkedList<>();
		next.add(0);

		dfs(info, next, 0, 0, 0);

		return answer;
	}

	private void dfs(int[] info, List<Integer> list, int node, int sheep, int wolf) {
		if (info[node] == 0) {
			sheep += 1;
		} else {
			wolf += 1;
		}
		
		if(sheep <= wolf) {
			return;
		}

		answer = Math.max(answer, sheep);

		List<Integer> next = new ArrayList<>(list);
		if(!GRAPH.get(node).isEmpty()) {
			next.addAll(GRAPH.get(node));
		}
		next.remove(Integer.valueOf(node));
		
		for(int n : next) {
			dfs(info, next, n, sheep, wolf);
		}
	}
}