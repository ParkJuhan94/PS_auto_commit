//package BOJ.Section05.P1003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Point[] dp = new Point[50];

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section05/P1003/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());

            fibonacci(N);

            System.out.println(dp[N].one + " " + dp[N].two);
        }

    }

    static Point fibonacci(int N) {
        if(dp[N] != null){
            return dp[N];
        }

        if (N == 0) {
            return dp[0] = new Point(1, 0);
        } else if (N == 1) {
            return dp[1] = new Point(0, 1);
        } else {
            return dp[N] = new Point(fibonacci(N - 1).one + fibonacci(N - 2).one,
                    fibonacci(N - 1).two + fibonacci(N - 2).two);
        }
    }

}

class Point{
    int one;
    int two;

    public Point(int one, int two) {
        this.one = one;
        this.two = two;
    }
}