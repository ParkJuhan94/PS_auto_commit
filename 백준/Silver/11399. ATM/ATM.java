//package WEEK0.P11399;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK0/P11399/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(arr);
        int ans = 0;
        int sum = 0;

        for(int i = 0; i < N; i++){
            sum += arr.get(i);
            ans += sum;
        }
        
        System.out.println(ans);
    }

}