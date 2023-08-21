//package BOJ.Section07.P17143;

import java.io.*;
import java.util.*;

public class Main {
    static int r,c;

    public static void main(String[] args) throws IOException{
     //   System.setIn(new FileInputStream("src/BOJ/Section07/P17143/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Shark> sharkList = new HashMap<>();
        
        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sharkList.put(i, new Shark(y,x,s,d,z));
            map[y][x] = i;
        }

        int ans = 0;
        int pos = -1;

        for(int t=0; t<c; t++) {
            pos++;

            for(int i=0; i<r; i++) {
                if(map[i][pos] >0) {
                    int sharkNum = map[i][pos];
                    ans += sharkList.get(sharkNum).z; // 상어 잡음

                    sharkList.remove(sharkNum);
                    map[i][pos]=0;
                    break;
                }
            }

            for(int key : sharkList.keySet()){
                Shark shark = sharkList.get(key);

                map[shark.r][shark.c] = 0;

                if(shark.d == 1)  {
                    if(move(shark,-1,shark.d)==1) shark.d = 2;
                }else if(shark.d == 2) {
                    if(move(shark,1,shark.d)==-1) shark.d = 1;
                }else if(shark.d == 3) {
                    if(move(shark,1,shark.d)==-1) shark.d = 4;
                }else {
                    if(move(shark,-1,shark.d)==1) shark.d = 3;
                }
            }

            List<Integer> removeList = new ArrayList<>();
            // 같은 위치에 있는 상어 경쟁
            for(int key : sharkList.keySet()){
                Shark sh = sharkList.get(key);
                if(map[sh.r][sh.c] > 0)	{
                    if(sharkList.get(map[sh.r][sh.c]).z > sh.z) {
                        removeList.add(key);
                    }else {
                        removeList.add(map[sh.r][sh.c]);
                        map[sh.r][sh.c] =key;
                    }
                }else {
                    map[sh.r][sh.c] =key;
                }
            }

            // 상어 제거
            for(int key : removeList) {
                sharkList.remove(key);
            }
        }

        System.out.println(ans);
    }

    static int move(Shark shark, int d, int type) {
        int move = shark.s;

        while(move > 0) {
            if(type == 1|| type == 2) {
                if(shark.r==0) d = 1;
                else if(shark.r==r-1) d = -1;

                shark.r += d;
            }else {
                if(shark.c==0) d = 1;
                else if (shark.c==c-1) d = -1;

                shark.c += d;
            }
            move--;
        }

        return d;
    }
}

class Shark{
    int r, c, s, d, z;

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}