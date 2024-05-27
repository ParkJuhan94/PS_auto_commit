//package BOJ.Section10.P4963;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int W, H;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int ans;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section10/P4963/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0) {
				return;
			}

			board = new int[H][W];
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(board[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}

			System.out.println(ans);
		}
	}

	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		visited[r][c] = true;
		boolean isIsland = false;

		if(board[r][c] == 1) {
			isIsland = true;
		}

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 8; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (0 <= nr && nr < H && 0 <= nc && nc < W &&
					board[nr][nc] == 1 && !visited[nr][nc]
				) {
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
					isIsland = true;
				}
			}
		}

		if(isIsland) {
			ans++;
		}
	}
}

class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
