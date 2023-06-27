//package BOJ.Practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Practice/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int sum = 0;
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++){
            sum += input.charAt(i) - '0';
        }

        System.out.println(sum);
    }

}