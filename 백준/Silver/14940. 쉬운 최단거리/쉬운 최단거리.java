//package BOJ.Section09.P14940;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] board;
	static boolean[][] visited;
	static int sr;
	static int sc;

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/BOJ/Section09/P14940/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					sr = i;
					sc = j;
					board[i][j] = 0;
				} else if (board[i][j] == 1) {
					board[i][j] = -1;
				}
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void bfs() {
		Queue<Point> q = new LinkedList();
		q.add(new Point(sr, sc));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < M &&
					board[nr][nc] != 0 && !visited[nr][nc]
				) {
					board[nr][nc] = board[cur.r][cur.c] + 1;
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
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
