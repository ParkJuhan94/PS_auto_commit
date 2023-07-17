//package BOJ.Section05.P1002;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section05/P1002/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            Point a = new Point(x1, y1);
            Point b = new Point(x2, y2);

            double dist = distance(a, b);

            if(dist == 0 && r1 == r2){
                System.out.println(-1);
                continue;
            }

            if(dist < r1 + r2)
            {
                if(dist > Math.abs(r1 - r2)){
                    System.out.println(2);
                }
                else if(dist == Math.abs(r1 - r2)){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }else if(dist > r1 + r2){
                System.out.println(0);
            }
            else{
                System.out.println(1);
            }
        }
    }

    static double distance(Point a, Point b){
        int powR = (int) Math.pow(a.r - b.r, 2);
        int powC = (int) Math.pow(a.c - b.c, 2);

        return Math.sqrt(powR + powC);
    }

}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}