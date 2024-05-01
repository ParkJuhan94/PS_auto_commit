//package Programmers.Level_3_2.프렌즈4블록;

import java.awt.*;
import java.util.ArrayList;

class Solution {
	int m, n;
	char[][] board;

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		this.m = m;
		this.n = n;
		this.board = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				this.board[i][j] = board[i].charAt(j);
			}
		}

		while (true) {
			// print();
			if (!removeBlocks()) {
				break;
			}
			moveBlocks();
		}

		// 빈 블록 갯수 세기
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (this.board[i][j] == ' ') {
					answer++;
				}
			}
		}

		return answer;
	}

	// 블록 지우기
	boolean removeBlocks() {
		boolean isRemoved = false;
		ArrayList<Point> forRemoveBlocks = new ArrayList<>();

		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (board[i][j] != ' '
					&& board[i][j] == board[i + 1][j]
					&& board[i][j] == board[i][j + 1]
					&& board[i][j] == board[i + 1][j + 1]
				) {
					forRemoveBlocks.add(new Point(i, j));
					forRemoveBlocks.add(new Point(i + 1, j));
					forRemoveBlocks.add(new Point(i, j + 1));
					forRemoveBlocks.add(new Point(i + 1, j + 1));
					isRemoved = true;
				}
			}
		}

		for (int i = 0; i < forRemoveBlocks.size(); i++) {
			int r = forRemoveBlocks.get(i).x;
			int c = forRemoveBlocks.get(i).y;
			board[r][c] = ' ';
		}

		return isRemoved;
	}

	// 블록 내리기
	void moveBlocks() {
		for (int j = 0; j < n; j++) {
			for (int i = m - 1; i >= 0; i--) {
				if (board[i][j] == ' ') {
					int targetRow = i;
					while (true) {
						targetRow--;
						if (targetRow < 0) {
							targetRow = 0;
							break;
						}
						if (board[targetRow][j] != ' ') {
							break;
						}
					}

					board[i][j] = board[targetRow][j];
					board[targetRow][j] = ' ';
				}
			}
		}
	}

	void print() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}



