//package BOJ.Section04.P1764;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section04/P1764/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }


        ArrayList<String> arrList = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if(set.contains(input)){
                arrList.add(input);
            }
        }
        Collections.sort(arrList);

        for(int i = 0; i < arrList.size(); i++){
            sb.append(arrList.get(i) + "\n");
        }

        System.out.println(arrList.size());
        System.out.print(sb);
    }

}