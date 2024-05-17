import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int ans = 0;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static ArrayList<Point> clouds = new ArrayList<>();
	static ArrayList<Point> prevClouds = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section10/P21610/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 구름 4칸
		clouds.add(new Point(N - 2, 0));
		clouds.add(new Point(N - 2, 1));
		clouds.add(new Point(N - 1, 0));
		clouds.add(new Point(N - 1, 1));

		// 명령
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			// 구름 이동
			int cloudSize = clouds.size();
			for (int j = 0; j < cloudSize; j++) {
				Point cloud = clouds.get(j);
				clouds.set(j,
					new Point((100 * N + cloud.r + dr[d - 1] * s) % N,
						(100 * N + cloud.c + dc[d - 1] * s) % N));
			}

			// 비 내리고 구름 사라짐
			cloudSize = clouds.size();
			for (int j = 0; j < cloudSize; j++) {
				Point cloud = clouds.get(j);
				map[cloud.r][cloud.c] += 1;
				prevClouds.add(new Point(cloud.r, cloud.c));
			}
			clouds.clear();

			// 물복사버그
			for (int j = 0; j < prevClouds.size(); j++) {
				Point prevCloud = prevClouds.get(j);

				int countDiagonalWater = countDiagonalWater(prevCloud.r, prevCloud.c);
				map[prevCloud.r][prevCloud.c] += countDiagonalWater;
			}

			// 구름이 생김
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(!wasCloud(r, c) && map[r][c] >= 2) { // 구름이 아니었고, 물의 양 2 이상이면
						clouds.add(new Point(r, c));
						map[r][c] -= 2;
						if(map[r][c] < 0) {
							map[r][c] = 0;
						}
					}
				}
			}
			prevClouds.clear();
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				ans += map[i][j];
			}
		}

		System.out.println(ans);
	}

	// 해당 칸에서 대각선에 물이 있{는 칸이 몇 개 인지
	static int countDiagonalWater(int r, int c) {
		int res = 0;

		for (int i = 0; i < 8; i++) {
			if (i % 2 == 1) {    // 대각선 방향이라면
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] > 0) {
					res++;
				}
			}
		}

		return res;
	}

	static boolean wasCloud(int r, int c) {
		for(int i = 0; i < prevClouds.size(); i++) {
			Point prevCloud = prevClouds.get(i);
			if(r == prevCloud.r && c == prevCloud.c) {
				return true;
			}
		}

		return false;
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
