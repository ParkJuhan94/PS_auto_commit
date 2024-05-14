import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static int ans = 0;
	static String[] strArr;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section10/P2866/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		strArr = new String[C];
		for (int i = 0; i < C; i++) {
			strArr[i] = "";
		}

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		solve();

		System.out.println(ans);
	}

	static void solve() {
		for (int i = 0; i < C; i++) {
			for (int j = 1; j < R; j++) {
				strArr[i] = strArr[i] + String.valueOf(map[j][i]);
			}
		}

		for (int i = 0; i < R - 1; i++) {
			// for(int j = 0; j < C; j++) {
			// 	System.out.print(strArr[j] + " ");
			// }
			// System.out.println();

			for (int j = 0; j < C; j++) {
				for (int k = j + 1; k < C; k++) {
					if (strArr[j].equals(strArr[k])) {
						return;
					}
				}
			}

			for (int j = 0; j < C; j++) {
				int len = strArr[j].length();
				strArr[j] = strArr[j].substring(1, len);
			}

			ans++;
		}
	}
}