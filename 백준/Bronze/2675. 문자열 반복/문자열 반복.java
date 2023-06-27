//package BOJ.Practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Practice/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0 ; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for(int i = 0; i < str.length(); i++){
                for(int j = 0; j < N; j++){
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }

}