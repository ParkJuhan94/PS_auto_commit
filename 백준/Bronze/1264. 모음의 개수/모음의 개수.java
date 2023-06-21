//package TEST.P1000;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int A, B, tmp;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/TEST/P1000/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String s = "";
        while(!(s = br.readLine()).equals("#")){
            int res = 0;

            for(int i =0; i < s.length(); i++){
                if(s.charAt(i) == 'A' || s.charAt(i) == 'a' ||s.charAt(i) == 'E' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
                        s.charAt(i) == 'I' || s.charAt(i) == 'O' ||s.charAt(i) == 'o' || s.charAt(i) == 'U' || s.charAt(i) == 'u'){
                    res++;
                }
            }

            System.out.println(res);
        }
    }
}