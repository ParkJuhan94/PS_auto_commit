

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int[] mx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] my = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    static int W, N;
    static char[][] map;
    static boolean[][] visited;
    static String answer;
    static int sum;
    static int count;
    static int maxScore, maxLen;
    static StringBuilder sb = new StringBuilder();
    static TrieNode root = new TrieNode();

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/DAY03/P9202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        W = Integer.parseInt(br.readLine());

        for (int i = 0; i < W; i++) {
            insertTireNode(br.readLine());
        }

        br.readLine();
        N = Integer.parseInt(br.readLine());
        StringBuilder resultSb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            map = new char[4][4];
            visited = new boolean[4][4];
            answer = "";
            sum = 0;
            count = 0;
            maxScore = 0;
            maxLen = 0;
            sb = new StringBuilder();

            for (int i = 0; i < 4; i++) {
                String in = br.readLine();
                for (int k = 0; k < 4; k++) {
                    map[i][k] = in.charAt(k);
                }
            }
            br.readLine();
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    //출발 가능 조건 -> root가 해당 child를 가지면
                    if (root.hasChild(map[y][x])) {
                        search(y, x, root.getChild(map[y][x]));
                    }
                }
            }
            //결과 출력
            root.clearHit();
            resultSb.append(sum + " ");
            resultSb.append(answer + " ");
            resultSb.append(count + "\n");
        }

        System.out.println(resultSb.toString());
    }

    static void search(int y, int x, TrieNode node) {
        // 1. 체크인 -> visited
        visited[y][x] = true;
        sb.append(map[y][x]);
        // 2. 목적지에 도달하였는가? -> isWord == true, isHit == false
        if (node.isWord == true && node.isHit == false) {
            node.isHit = true;
            //답 작업 -> 길이, 단어
            String foundWord = sb.toString();
            int length = foundWord.length();

            if(length > maxLen){
                maxLen = length;
                answer = foundWord;
            }else if(length == maxLen){
                if(answer.compareTo(foundWord) > 0){
                    answer = foundWord;
                }
            }

            sum += score[length];
            count++;
        }
        // 3. 연결된 곳을 순회 -> 8방
        for (int i = 0; i < 8; i++) {
            int ty = y + my[i];
            int tx = x + mx[i];
            // 4. 가능한가? - map경계, 방문하지 않았는지, node가 해당 자식을 가지고 있는지
            if (0 <= ty && ty < 4 && 0 <= tx && tx < 4) {
                if (visited[ty][tx] == false && node.hasChild(map[ty][tx])) {
                    // 5. 간다
                    search(ty, tx, node.getChild(map[ty][tx]));
                }
            }
        }
        // 6. 체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    static void insertTireNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            int index = a - 'A';
            if (current.chlid[index] == null) {
                current.chlid[index] = new TrieNode();
            }
            current = current.chlid[index];
        }
        current.isWord = true;
    }
}

class TrieNode {
    boolean isWord = false;
    boolean isHit = false;
    TrieNode[] chlid = new TrieNode[26];

    void clearHit() {
        isHit = false;
        for (int i = 0; i < chlid.length; i++) {
            if (chlid[i] != null) {
                chlid[i].clearHit();
            }
        }
    }

    boolean hasChild(char c) {
        return chlid[c - 'A'] != null;
    }

    TrieNode getChild(char c) {
        return chlid[c - 'A'];
    }
}