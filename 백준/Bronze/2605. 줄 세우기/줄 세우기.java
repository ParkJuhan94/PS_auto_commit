//package BOJ.Section04.P2605;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section04/P2605/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1]; // 학생번호가 1번부터 시작하니까
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackTemp = new Stack<>();

        for(int i = 1; i <= N; i++){
            int numPop = arr[i];

            // 제칠 학생들을 뽑아서 temp에 넣어놓고
            for(int j = 0; j < numPop; j++){
                int student = stack.pop();
                stackTemp.add(student);
            }

            // 삽입
            stack.push(i);

            // temp의 학생들을 다시 줄 세움
            while(!stackTemp.isEmpty()){
                int student = stackTemp.pop();
                stack.push(student);
            }
        }

        Iterator it = stack.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

}