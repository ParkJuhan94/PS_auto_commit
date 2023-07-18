//package BOJ.Section05.P17413;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section05/P17413/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();

        boolean isWord = true;

        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);

            // 단어 온
            if(c == '<'){
                isWord = false;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append('<');
                continue;
            }

            if(isWord){     // 단어라면
                if(c == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }else{
                    stack.add(c);
                }
            }
            else    // 태그라면
            {
                sb.append(c);
            }

            // 단어 오프
            if(c == '>'){
                isWord = true;
            }

            // 남은게 있다면 출력
            if(i == S.length() - 1){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb);
    }

}