//package BOJ.Section08.P2607;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;
        String standard = br.readLine();
        int len = standard.length();
        int[] alphabet = new int[26];
        
        for (int i = 0; i < len; i++) {
            alphabet[standard.charAt(i) - 'A']++;
        }

        int ans = 0;
        while (N-- > 0) {
            int[] temp = alphabet.clone();
            String comp = br.readLine();
            int cnt = 0;
            
            for (int i = 0; i < comp.length(); i++) {
                if (temp[comp.charAt(i) - 'A'] > 0) {
                    cnt++;
                    temp[comp.charAt(i) - 'A']--;
                }
            }

            if (len - 1 == comp.length() && cnt == comp.length()) { //길이가 -1
                ans++;
            } else if (len == comp.length()) { //길이가 equal
                if (cnt == len || cnt == len - 1) ans++;
            } else if (len + 1 == comp.length()) { //길이가 +1
                if (cnt == len) ans++;
            }
        }

        System.out.println(ans);
    }

}
