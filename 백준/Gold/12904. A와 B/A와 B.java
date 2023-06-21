//package WEEK00.P12904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK00/P12904/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        String str1 = st.nextToken();
        String str2 = br.readLine();

        while(true){
            if(str2.length() == str1.length()){
                if(str2.equals(str1)){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
                break;
            }

            if(str2.charAt(str2.length() - 1) == 'A'){
                str2 = str2.substring(0, str2.length() - 1);
            }else if(str2.charAt(str2.length() - 1) == 'B'){
                str2 = str2.substring(0, str2.length() - 1);
                String reverse = "";
                for(int i = str2.length() - 1; i >= 0; i--){
                    reverse += str2.charAt(i);
                }
                str2 = reverse;
            }
        }
    }

}