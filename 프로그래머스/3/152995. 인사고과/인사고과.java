//package Programmers.Level_3_2.인사고과;

import java.util.Arrays;

class Solution {
	public int solution(int[][] scores) {

		int[] myScore = scores[0];

		// a 내림차순 다음에 b 오름차순
		Arrays.sort(
			scores,
			(a, b) -> {
				if (a[0] == b[0]) {
					return Integer.compare(a[1], b[1]);
				} else {
					return Integer.compare(a[0], b[0]) * (-1);
				}
			}
		);

		int rank = 0;
		int maxB = 0;
		for (int i = 0; i < scores.length; i++) {

			int[] score = scores[i];
			boolean isPossible = true; // 해당 점수의 사람이 인센 받을 수 있는지

			if (maxB < score[1]) {
				maxB = score[1];
			} else if (maxB > score[1]) {
				isPossible = false;
			}

			// 인센 못 받는다면
			if (!isPossible) {
				// 원호이거나 동점의 사람이라면
				if (score[0] == myScore[0] && score[1] == myScore[1]) {
					return -1;
				}
				continue;
			}

			// 원호보다 높은 합산 점수만 카운트
			if((score[0] + score[1]) > (myScore[0] + myScore[1])){
				rank++;
			}
		}

		return ++rank;
	}
}
