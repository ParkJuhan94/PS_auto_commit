

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/DAY06/P1717/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 0 ; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 0){
                union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }else{
                if(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()))){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b) parent[b] = a;
    }

    static int find(int a){
        if(parent[a] == a){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }
}
