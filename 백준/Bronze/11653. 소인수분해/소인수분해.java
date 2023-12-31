//package BOJ.Section04.P1929;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        //  System.setIn(new FileInputStream("src/BOJ/Section04/P1929/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = 2; i <= Math.sqrt(N); i++) {
	        while(N % i == 0) {
		        System.out.println(i);
		        N /= i;
	        }
        }
 
        if(N != 1) {
	        System.out.println(N);
        }
    }

}