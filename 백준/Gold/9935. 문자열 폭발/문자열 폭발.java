//package WEEK00.P9935;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/WEEK00/P9935/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        String str = st.nextToken();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));

            // stack 의 사이즈가 bomb 길이와 같거나 크면 검사
            if(stack.size() >= bomb.length()){
                boolean isBomb = true;
                for(int j = 0; j < bomb.length(); j++){
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
                        isBomb = false;
                        break;
                    }
                }

                // 폭탄이면 스택에서 제거
                if(isBomb){
                    for(int j = 0; j < bomb.length(); j++){
                        stack.pop();
                    }
                }
            }
        }

        for(char ch : stack){
            sb.append(ch);
        }

        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            System.out.print(sb);
        }
    }

}