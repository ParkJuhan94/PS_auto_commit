//package BOJ.Section04.P4134;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section04/P4134/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; ++i) {
            long testValue = Long.parseLong(br.readLine());
            BigInteger nextPrimeNumber = new BigInteger(String.valueOf(testValue));

            if (nextPrimeNumber.isProbablePrime(10)) {  // 현재 값이 소수면 그대로 출력
                System.out.println(nextPrimeNumber);
            } else {        // 현재 값이 소수가 아니면 다음 소수를 구해서 출력
                System.out.println(nextPrimeNumber.nextProbablePrime());
            }
        }
    }

}