//package BOJ.Section07.P1525;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String correct = "123456780";    // 목표
    static Map<String, Integer> map = new HashMap<>();  // 맵의 상태, 이동 횟수
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static String init = "";
    static int ans = -1;

    public static void main(String[] args) throws IOException{
   //     System.setIn(new FileInputStream("src/BOJ/Section07/P1525/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                int num = Integer.parseInt(st.nextToken());
                init += num;
            }
        }

        map.put(init, 0);

        bfs();

        System.out.println(ans);
    }

    static void bfs(){

        Queue<String> q = new LinkedList<>();
        q.add(init);

        while(!q.isEmpty()){
            String cur = q.poll();
            int moveCnt = map.get(cur);
            int empty = cur.indexOf('0');
            int r = empty / 3;
            int c = empty % 3;

            if(cur.equals(correct)){
                ans = moveCnt;
            }

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(0 <= nr && nr < 3 && 0 <= nc && nc < 3){
                    // q에 넣을 맵 상태 만들기
                    int changeIdx = nr * 3 + nc;
                    char ch = cur.charAt(changeIdx);
                    String next = cur.replace('0', '!');
                    next = next.replace(ch, '0');
                    next = next.replace('!', ch);

                    // 방문체크
                    if(!map.containsKey(next)){
                        q.add(next);
                        map.put(next, moveCnt + 1);
                    }
                }
            }

        }


    }

}