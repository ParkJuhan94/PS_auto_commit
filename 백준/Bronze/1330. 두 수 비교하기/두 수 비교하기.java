//package TEST.P1000;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int A, B, tmp;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/TEST/P1000/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        if (A > B) {
            System.out.println('>');
        } else if (A < B) {
            System.out.println('<');
        } else {
            System.out.println("==");
        }
    }
}