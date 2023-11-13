//package BOJ.Section08.P19637;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Nick {
    String name;
    int limit;

    public Nick(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }
}

public class Main {
    static int N, M;
    static List<Nick> nickList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section08/P19637/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String nickName = st.nextToken();
            int nickLimit = Integer.parseInt(st.nextToken());

            nickList.add(new Nick(nickName, nickLimit));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(br.readLine());
            String output = BinarySearch(input);
            sb.append(output + "\n");
        }

        System.out.println(sb);
    }

    private static String BinarySearch(int score) {
        int start = 0;
        int end = nickList.size() - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (score > nickList.get(mid).limit) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nickList.get(end + 1).name;
    }
}
