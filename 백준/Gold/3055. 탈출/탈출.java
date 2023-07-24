
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] dp;
    static Queue<point> queue;
    static boolean foundAnswer;
    static point st;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};


    public static void main(String args[]) throws FileNotFoundException {
       // System.setIn(new FileInputStream("src/DAY01/P3055/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<>();

        for(int r = 0 ; r < R; r++){
            String line = sc.next();
            for(int c = 0; c < C; c++){
                map[r][c] = line.charAt(c);
                if(map[r][c] == '*') {
                    queue.add(new point(r,c,'*'));
                }else if(map[r][c] == 'S'){
                    st = new point(r,c,'S');
                }
            }
        }
        queue.add((st));

        while(!queue.isEmpty()){
            //1. 큐에서 꺼내옴 -> *, ㄴ, ., D (갈 곳)
            point p = queue.poll();
            //2. 목적지인가? -> D
            if(p.type == 'D'){
                foundAnswer = true;
                System.out.println(dp[p.y][p.x]);
                break;
            }
            //3. 연결된 곳을 순회 -> 상하좌우
            for(int i = 0; i < 4; i++){
                int ty = p.y + dy[i];
                int tx = p.x + dx[i];

                //4. 갈 수 있는가? (공통) : 맵 안에 들어오는가
                if(0 <= ty && ty < R && 0 <= tx && tx < C){
                    //4. 갈 수 있는가? (고슴도치) : . or D, 방문하지 않은 곳
                    if(p.type == 'S' || p.type == '.'){
                        if((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0){
                            //5. 체크인 (고슴도치) : dp[][] = 이동거리
                            dp[ty][tx] = dp[p.y][p.x] + 1;
                            //6. 큐에 넣음
                            queue.add(new point(ty, tx, map[ty][tx]));
                        }
                    }else if(p.type == '*'){    //중간 에러 방지
                        //4. 갈 수 있는가? (물) : .
                        if(map[ty][tx] == '.' || map[ty][tx] == 'S'){
                            //5. 체크인 (물) : map[][] = *
                            map[ty][tx] = '*';
                            //6. 큐에 넣음
                            queue.add(new point(ty,tx,'*'));
                        }
                    }
                }
            }
        }

        if(!foundAnswer) System.out.println("KAKTUS");
    }

    static class point{
        point(int y,int x,char type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
        int x,y;
        char type;
    }
}
