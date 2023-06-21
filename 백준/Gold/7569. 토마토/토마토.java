//package PS_01.P7569;

import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int answer;
    static int[][][] arr;
    static Queue<Point> Q;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
 //       System.setIn(new FileInputStream("src/PS_01/P7569/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N][M][H];
        Q = new LinkedList<>();
        answer = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {     // 익은 토마토의 위치 저장
                        Q.add(new Point(i, j, k));
                    }
                }
            }
        }


        // 저장될 때부터 모든 토마토가 익어있을 때 0
        exception(arr, true);

        // 탐색
        search(Q);
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (answer < arr[i][j][k]) {
                        answer = arr[i][j][k];
                    }
                }
            }
        }

        // 토마토가 모두 익지는 못할 때 -1
        exception(arr, false);

        // 첫날 익은 토마토가 1이 아닌, 2로 저장되어있으니까 -1 해준다.
        System.out.println(answer - 1);
    }

    // BFS
    static void search(Queue<Point> Q) {
        while(!Q.isEmpty()){
            // 익은 토마토 꺼내서 순회
            Point front = Q.remove();

            // 네방향 탐색
            int flag = 0;

            for(int i = 0; i < 6; i++){
                int xx = front.x + dx[i];
                int yy = front.y + dy[i];
                int zz = front.z + dz[i];

                if(0 <= xx && xx < N && 0 <= yy && yy < M && 0 <= zz && zz < H){
                    // 덜 익었나?
                    if(arr[xx][yy][zz] == 0){
                        // 덜 익었으면 익히고, arr에 소요된 날짜를 넣는다.
                        // 하루 지나는거니까 +1
                        arr[xx][yy][zz] = arr[front.x][front.y][front.z] + 1;
                        Q.add(new Point(xx, yy, zz));
                    }
                }
            }
        }
    }

    static void exception(int[][][] arr, Boolean isStart){
        int flag = 0;
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j][k] == 0) {
                        flag = 1;
                    }
                }
            }
        }

        //시작부분에서 모든 토마토가 익었는지 체크
        if(isStart && flag == 0) {
            System.out.println(0);
            System.exit(0);
        }

        //끝부분에서 모든 토마토가 익었는지 체크
        if(!isStart && flag == 1) {
            System.out.println(-1);
            System.exit(0);
        }
    }
}

class Point{
    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}