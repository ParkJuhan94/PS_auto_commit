//package WEEK0.P1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<conference> arr;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK0/P1931/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arr);

//        for(int i = 0; i < N; i++){
//            System.out.println(arr.get(i));
//        }

        // 첫 회의 집어넣기
        int ans = 1;
        long end = arr.get(0).end; // 회의가 끝나는 지점

        //System.out.println(arr.get(0).start + " " + arr.get(0).end);
        for(int i = 1; i < arr.size(); i++){
            if (arr.get(i).start >= end) {
                end = arr.get(i).end;
                //System.out.println(arr.get(i).start + " " + arr.get(i).end);
                ans++;
            }
        }

        System.out.println(ans);
    }

}

class conference implements Comparable<conference> {
    long start;
    long end;

    public conference(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(conference o) {
        if(end != o.end){
            return (int) (end - o.end);
        } else {
            return (int) (start - o.start);
        }
    }

    @Override
    public String toString() {
        return "conference{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}