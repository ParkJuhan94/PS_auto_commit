//package BOJ.Section07.P16235;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][] addMap;
    static int[] dr = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};
    static Queue<Tree> trees = new LinkedList<>();
    static ArrayList<Tree> dieTrees;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section07/P16235/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        addMap = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = 5;
                addMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, z));
        }

        Collections.sort((List<Tree>)trees);

        for(int i = 0; i < K; i++){
            oneYear();
        }

//        printTrees();
        System.out.println(trees.size());
    }

    static void oneYear() {

        dieTrees = new ArrayList<>();

        // 봄
        int size = trees.size();

        for(int i = 0; i < size; i++)
        {
            Tree cur = trees.poll();
            int r = cur.r;
            int c = cur.c;
            int age = cur.age;

            if(map[r][c] >= age){
                map[r][c] -= age;
                trees.add(new Tree(r, c, age + 1));
            }else{
                // 죽는다
                dieTrees.add(cur);
            }
        }

        // 여름
        for(Tree cur : dieTrees){
            map[cur.r][cur.c] += (cur.age / 2);
        }

        // 가을
        ArrayList<Tree> parentTrees = new ArrayList<>();
        size = trees.size();

        for(int i = 0; i < size; i++)
        {
            Tree cur = trees.poll();
            parentTrees.add(cur);

            if(cur.age % 5 == 0){
                for(int j = 0; j < 8; j++){
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];

                    if(0 <= nr && nr < N && 0 <= nc && nc < N) {
                        trees.add(new Tree(nr, nc, 1));
                    }
                }
            }
        }

        // 자식 먼저 넣고 부모 넣는다. (정렬되게)
        for(Tree t : parentTrees){
            trees.add(t);
        }

        // 겨울
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] += addMap[i][j];
            }
        }
    }

    static void printTrees() {
        for (Tree t : trees) {
            System.out.println(t.r + ", " + t.c);
        }
        System.out.println();
    }
}

class Tree implements Comparable<Tree>{
    int r;
    int c;
    int age;

    public Tree(int r, int c, int age) {
        this.r = r;
        this.c = c;
        this.age = age;
    }

    @Override
    public int compareTo(Tree o) {
        return age - o.age;
    }
}