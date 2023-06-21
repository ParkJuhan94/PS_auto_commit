//package WEEK00.P7568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, x, y;
    static Body[] bodys;
    static int[] ranks;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK00/P7568/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        bodys = new Body[N];
        ranks = new int[N];
        Arrays.fill(ranks, 1);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bodys[i] = new Body(x, y);
        }

        setRank();

        for(int i = 0; i < N; i++){
            System.out.print(ranks[i] + " ");
        }
        System.out.println();
    }

    static void setRank(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j != i){
                    if(bodys[j].x > bodys[i].x && bodys[j].y > bodys[i].y){
                        ranks[i]++;
                    }
                }
            }
        }
    }
}

class Body{
    int x,y;

    public Body(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
