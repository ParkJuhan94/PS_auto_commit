//package BOJ.Section05.P1374;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section05/P1374/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        ArrayList<Time> lessons = new ArrayList<>();
        for (int i = 0; i < N; i++){
            String[] info = br.readLine().split(" ");

            lessons.add(new Time(Integer.parseInt(info[0]),
                    Integer.parseInt(info[1]), Integer.parseInt(info[2])));
        }

        // 정렬 : 1. 시작시간이 빠른순 2. 종료시각이 빠른순
        Collections.sort(lessons);

        PriorityQueue<Integer> q = new PriorityQueue<>();

        int max = 1;

        for (int i = 0; i < N; i++){
            while (!q.isEmpty() && q.peek() <= lessons.get(i).start){
                q.poll();
            }
            q.offer(lessons.get(i).end);
            max = Math.max(max, q.size());
        }


        System.out.println(max);
    }

}


class Time implements Comparable<Time>{
    int num;
    int start;
    int end;

    @Override
    public int compareTo(Time t){
        if (this.start == t.start) return this.end - t.end;
        return this.start - t.start;
    }

    public Time(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }
}