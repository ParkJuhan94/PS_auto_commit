//package BOJ.Section10.P2239;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] rows = new boolean[9][10];
	static boolean[][] cols = new boolean[9][10];
	static boolean[][] smallBoards = new boolean[9][10]; // 3x3 보드
	/*
	rows[i][j]: i번째 row에 j가 있는가?
	cols[i][j]: i번째 col에 j가 있는가?
	 */
	static int[][] board = new int[9][9];

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section10/P2239/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String str = br.readLine();

			for (int j = 0; j < 9; j++) {
				int inputNum = str.charAt(j) - '0';
				board[i][j] = inputNum;
				rows[i][inputNum] = true;
				cols[j][inputNum] = true;
				smallBoards[3 * (i / 3) + (j / 3)][inputNum] = true;
			}
		}

		sudoku(0);
	}

	static void sudoku(int idx) {
		if (idx >= 81) {    // 종료 조건
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j] + "");
				}
				System.out.println();
			}

			System.exit(0);
		}

		int r = idx / 9;
		int c = idx % 9;

		if (board[r][c] != 0) {
			sudoku(idx + 1);
		} else {
			for (int i = 1; i < 10; i++) {
				if (rows[r][i] || cols[c][i] || smallBoards[3 * (r / 3) + c / 3][i]) {
					continue;
				}
				
				rows[r][i] = true;
				cols[c][i] = true;
				smallBoards[3 * (r / 3) + c / 3][i] = true;
				board[r][c] = i;
				sudoku(idx + 1);
				rows[r][i] = false;
				cols[c][i] = false;
				smallBoards[3 * (r / 3) + c / 3][i] = false;
				board[r][c] = 0;
			}
		}
	}
}
