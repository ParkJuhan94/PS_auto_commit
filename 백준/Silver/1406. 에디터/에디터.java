//package BOJ.Section08.P1406;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String str;
    static Stack<Character> leftStack = new Stack<>();
    static Stack<Character> rightStack = new Stack<>();

    public static void main(String[] args) throws IOException {
    //    System.setIn(new FileInputStream("src/BOJ/Section08/P1406/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        str = st.nextToken();
        for(int i = 0; i < str.length(); i++){
            leftStack.push(str.charAt(i));
        }
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String command = br.readLine();
            if(command.charAt(0) == 'L'){
                if(leftStack.isEmpty()){
                    continue;
                }
                commandL();
            }else if(command.charAt(0) == 'D'){
                if(rightStack.isEmpty()){
                    continue;
                }
                commandD();
            }else if(command.charAt(0) == 'B'){
                if(leftStack.isEmpty()){
                    continue;
                }
                commandB();
            }else if(command.charAt(0) == 'P'){
                char c = command.charAt(2);
                commandP(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }

    static public void commandL() {
        Character c = leftStack.pop();
        rightStack.push(c);
    }

    static public void commandD() {
        Character c = rightStack.pop();
        leftStack.push(c);
    }

    static public void commandB() {
        leftStack.pop();
    }

    static public void commandP(char c) {
        leftStack.push(c);
    }
}
