//package Programmers.Level_3_2.디스크컨트롤러;

import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		int answer = 0;
		Queue<int[]> controller = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		int idx = 0, time = jobs[0][0];

		while (idx < jobs.length || !controller.isEmpty())
		{
			while (idx < jobs.length && jobs[idx][0] <= time) {
				controller.add(jobs[idx++]);
			}

			if (controller.isEmpty()) {
				time = jobs[idx][0];
				controller.add(jobs[idx++]);
			}

			int[] job = controller.poll();
			time += job[1];

			answer += time - job[0];
		}

		return answer / jobs.length;
	}
}
