import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int[] parent;
    public static void main(String[] args)throws IOException {
   //     System.setIn(new FileInputStream("src/DAY06/P1922/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        //  비용을 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        int a, b, c;
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b,c});
        }

//      pq 정렬 확인
//        while(!pq.isEmpty()){
//            int[] tmp = pq.poll();
//            for(int n : tmp){
//                System.out.print(n + " ");
//            }
//            System.out.println();
//        }

        int cnt = 0, total = 0;
        //  union 이 N-1 번 되면 탈출 : 모든 정점이 연결 되어있음 (사이클이 없도록 만들었으니까)
        while(cnt < N-1 && !pq.isEmpty()){
            int[] tmp = pq.poll();
            //  출발점과 도착점이 같은 집합인지 확인
            //  최소비용 스패닝트리는 사이클이 형성되면 안돼 !
            if(find(tmp[0]) != find(tmp[1])){
                cnt++;
                union(tmp[0], tmp[1]);
                total += tmp[2];
            }
        }
        System.out.println(total);
    }

    static int find(int x){
        return parent[x] = (parent[x] == x) ? x : find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }
}