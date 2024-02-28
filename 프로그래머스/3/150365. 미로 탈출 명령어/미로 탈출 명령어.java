

import java.util.ArrayList;
import java.util.List;

class Solution {

	// (하,좌,우,상) 우선순위 부여
	int[] dr = {1, 0, 0, -1};
	int[] dc = {0, -1, 1, 0};
	// 인덱스에 맞는 문자 매핑
	String[] dir = {"d", "l", "r", "u"};
	int endR, endC;
	int n, m;
	int r, c;
	boolean[][][] visited = new boolean[51][51][2501];
	boolean isFinish = false;

	// 일단 숫자로 받은 다음 문자로 전환할 것임
	List<Integer> result;

	public String solution(int n, int m, int x, int y, int r, int c, int k) {

		String answer = "";
		this.n = n;
		this.m = m;
		this.r = x;
		this.c = y;
		endR = r;
		endC = c;

		dfs(x, y, k, new ArrayList<>());

		StringBuilder sb = new StringBuilder();

		if (result == null)
			answer = "impossible";
		else {
			for (int i : result) {
				sb.append(dir[i]);
			}
			answer = sb.toString();
		}
		return answer;
	}

	void dfs(int r, int c, int k, List<Integer> cnt) {
		if (isFinish) {
			return;
		}

		if (k <= 0) {
			if (r == endR && c == endC) {
				result = cnt;
				isFinish = true;
			}
			return;
		}

		// 우선순위대로 반복
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// k-1은 이동 이후의 남은 횟수를 뜻함
			if (nr > n || nc > m || nr < 1 || nc < 1 || visited[nr][nc][k - 1])
				continue;

			visited[nr][nc][k - 1] = true;
			List<Integer> list = new ArrayList<>(cnt);
			list.add(i);
			
			dfs(nr, nc, k - 1, list);
			
			if (isFinish) {
				return;
			}
		}
	}
}
