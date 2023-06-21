//package WEEK00.P13913;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[] visited = new int[100001]; // 방문 여부를 체크하기 위한 배열
    static int[] parent = new int[100001]; // 이전 위치를 저장하는 배열

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK00/P13913/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);

        // 경로 추적을 위한 스택
        Stack<Integer> path = new Stack<>();
        int current = k;

        while (current != n) {
            path.push(current);
            current = parent[current];
        }

        path.push(n);

        // 최소 시간 출력
        System.out.println(visited[k] - 1);

        // 경로 출력
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // 시작 위치를 큐에 삽입
        visited[start] = 1; // 시작 위치를 방문 처리

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 위치를 큐에서 추출

            if (current == end) {
                return; // 동생의 위치에 도달한 경우 종료
            }

            // 다음 위치로 이동하는 경우의 수를 계산
            int[] next = {current - 1, current + 1, current * 2};

            for (int i = 0; i < 3; i++) {
                if (next[i] >= 0 && next[i] <= 100000) { // 범위를 벗어나지 않는 경우
                    if (visited[next[i]] == 0) { // 방문하지 않은 위치인 경우
                        queue.offer(next[i]); // 다음 위치를 큐에 삽입
                        visited[next[i]] = visited[current] + 1; // 최소 시간 갱신
                        parent[next[i]] = current; // 이전 위치 저장
                    }
                }
            }
        }
    }
}
