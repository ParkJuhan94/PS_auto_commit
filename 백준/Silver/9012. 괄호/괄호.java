//package BOJ.Section04.P9012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section04/P9012/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            String inputStr = br.readLine();

            if(isVPS(inputStr)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    static boolean isVPS(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }

    }
}