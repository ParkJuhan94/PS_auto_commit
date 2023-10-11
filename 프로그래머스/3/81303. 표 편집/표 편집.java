// package Programmers.Level_3.표편집;

import java.util.Stack;

class Solution {
    static Node cur;
    static Stack<Node> deletedNodes = new Stack<>();;

    static class Node {
        Node prev = null;
        Node next = null;
        boolean isDeleted = false;
    }

    void upCursor(int move) {
        for(int i = 0; i < move; i++)
            cur = cur.prev;
    }

    void downCursor(int move){
        for(int i = 0; i < move; i++)
            cur = cur.next;
    }

    void delete(){
        cur.isDeleted = true;
        deletedNodes.push(cur);

        Node prev = cur.prev;
        Node next = cur.next;

        if(prev != null)
            prev.next = next;

        if(next != null){
            next.prev = prev;
            cur = next;
        }else{      // 삭제된 cur 가 마지막 행이었다면
            cur = prev;
        }
    }

    void restore(){
        Node node = deletedNodes.pop();
        Node prev = node.prev;
        Node next = node.next;
        node.isDeleted = false;

        if(prev != null)
            prev.next = node;

        if(next != null)
            next.prev = node;
    }

    public String solution(int n, int k, String[] cmd) {

        // nodeArr 초기화
        Node[] nodeArr = new Node[1_000_001];

        nodeArr[0] = new Node();
        for (int i = 1; i < n; i++) {
            nodeArr[i] = new Node();
            nodeArr[i].prev = nodeArr[i - 1];
            nodeArr[i - 1].next = nodeArr[i];
        }

        cur = nodeArr[k];   // 처음 선택한 노드

        for (String s : cmd) {
            char c = s.charAt(0);

            if (c == 'U') {
                int move = Integer.parseInt(s.substring(2));
                upCursor(move);
            } else if (c == 'D') {
                int move = Integer.parseInt(s.substring(2));
                downCursor(move);
            } else if (c == 'C') {
                delete();
            } else if (c == 'Z') {
                restore();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(nodeArr[i].isDeleted){
                sb.append("X");
            }else{
                sb.append("O");
            }
        }

        return sb.toString();
    }
}