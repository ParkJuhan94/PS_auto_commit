//package BOJ.Section09.P2668;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer> resultList;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/BOJ/Section09/P2668/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		visited = new boolean[N + 1];
		resultList = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int j = 1; j <= N; j++) {
			visited[j] = true;
			dfs(j, j);
			visited[j] = false;
		}

		// 뽑힌 정수들의 개수
		System.out.println(resultList.size());

		// 뽑힌 정수들을 작은 수부터 큰 수의 순서
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}

	static void dfs(int start, int target) {
		if(!visited[arr[start]]) {
			visited[arr[start]] = true;
			dfs(arr[start], target);
			visited[arr[start]] = false;
		}

		// 사이클이 발생했다면 마지막 수를 넣어줌
		if(arr[start] == target) {
			resultList.add(target);
		}
	}
}
