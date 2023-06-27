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
       // System.setIn(new FileInputStream("src/BOJ/Practice/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for(int i = 0; i < input.length(); i++){
            if(alphabet[input.charAt(i) - 'a'] == -1){
                alphabet[input.charAt(i) - 'a'] = i;
            }
        }

        for(int i = 0; i < 26; i++){
            System.out.print(alphabet[i] + " ");
        }
    }

}