//package BOJ.Section08.P20310;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int numZero, numOne;
    static int countZero, countOne;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section08/P20310/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                numZero++;
            }else{
                numOne++;
            }
        }

        countZero = 0;
        countOne = 0;

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                if(countZero < numZero / 2){
                    result.append("0");
                    countZero++;
                }
            }else{
                if(countOne < numOne / 2 && countZero >= numZero / 2){
                    result.append("1");
                    countOne++;
                }
            }
        }

        System.out.println(result);
    }

}
