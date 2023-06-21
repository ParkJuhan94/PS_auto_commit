//package BOJ.Silver.P10773;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Silver/P10773/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        stack = new Stack<>();
        cnt = 0;
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());

            if(input == 0){
                stack.pop();
            }else{
                stack.push(input);
            }
        }

        while(!stack.isEmpty()){
            cnt += stack.pop();
        }

        System.out.println(cnt);
    }

}
