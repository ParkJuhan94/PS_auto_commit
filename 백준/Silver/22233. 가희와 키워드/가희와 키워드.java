//package BOJ.Section08.P22233;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section08/P22233/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        String[] inputs = {};
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            inputs = input.split(",");

            for (int j = 0; j < inputs.length; j++) {
                set.remove(inputs[j]);
            }

            System.out.println(set.size());
        }
    }

}
