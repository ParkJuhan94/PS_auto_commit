//package WEEK0.P5430;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> arr;
    static ArrayDeque<Integer> deque;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK0/P5430/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < TC; tc++) {
            String op = br.readLine();
            N = Integer.parseInt(br.readLine());

            String input = br.readLine();
            input = input.replace("[", "");
            input = input.replace("]", "");
            String[] input_ = input.split(",");
            //arr = new ArrayList<>();
            deque = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                deque.add(Integer.parseInt(input_[i]));
            }

            // 연산 시작
            boolean reverse = false;
            int flag = 0; // error 일 때 종료조건

            for (int i = 0; i < op.length(); i++) {
                if (op.charAt(i) == 'R') {
                    // 실제로 뒤집는게 아니라, 방향 변수 reverse 만 역전시켜주기
                    reverse = (reverse == true) ? false : true;
                } else if (op.charAt(i) == 'D') {
                    // 원소가 하나도 없으면 에러 출력
                    if (deque.size() == 0) {
                        flag = 1;
                        break;
                    }

                    // 원소가 하나라도 있으면 삭제
                    if (reverse) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if(flag == 1){
                sb.append("error" + "\n");
                continue;
            }

            // 원소의 개수가 0 일때도 출력 돼야해 빈 괄호로!
            sb.append("[");
            if (reverse) {
                while (!deque.isEmpty()) {
                    if (deque.size() == 1) {
                        sb.append(deque.pollLast());
                    } else {
                        sb.append(deque.pollLast() + ",");
                    }

                }
            } else {
                while (!deque.isEmpty()) {
                    if (deque.size() == 1) {
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollFirst() + ",");
                    }
                }
            }
            sb.append("]" + "\n");
        }

        System.out.println(sb);
    }
}