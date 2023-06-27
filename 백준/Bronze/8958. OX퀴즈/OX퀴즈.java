//package BOJ.Section04.P8958;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section04/P8958/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            int sum = 0;
            int prev = 0;

            for(int j = 0; j < input.length(); j++){
                if(input.charAt(j) == 'O'){
                    prev++;
                    sum += prev;
                }else{
                    prev = 0;
                }
            }

            System.out.println(sum);
        }
    }

}