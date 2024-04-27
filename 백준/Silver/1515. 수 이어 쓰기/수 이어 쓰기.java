//package BOJ.Section09.P1515;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String input;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section09/P1515/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int p = 0;

        int base = 0;
        while (base++ <= 30000) {
            String tmp = String.valueOf(base);
            
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(p))
                    p++;
                if (p == s.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}
