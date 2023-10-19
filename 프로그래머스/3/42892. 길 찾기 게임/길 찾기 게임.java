import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static int preIdx = 0, postIdx = 0;
    static int[][] node_info_g, answer;
    static List<Node> nodeList;

    static class Node implements Comparable<Node> {
        int idx;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            left = null;
            right = null;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }

        @Override
        public int compareTo(Node o) {
            return o.y - this.y;
        }
    }

    static void initNode(Node cur, Node child) {
        if (cur.x > child.x) {
            if (cur.left == null) {
                cur.setLeft(child);
            } else {
                initNode(cur.left, child);
            }
        } else {
            if (cur.right == null) {
                cur.setRight(child);
            } else {
                initNode(cur.right, child);
            }
        }
    }

    // 순회
    static void search(Node cur) {
        if (cur == null)
            return;

        answer[0][preIdx++] = cur.idx; // 전위 순회
        search(cur.left);
        search(cur.right);
        answer[1][postIdx++] = cur.idx; // 후위 순회
    }

    public int[][] solution(int[][] nodeinfo) {
        node_info_g = nodeinfo;
        nodeList = new ArrayList<>();
        int size = nodeinfo.length;
        answer = new int[2][size];

        for (int i = 1; i <= size; i++) {
            nodeList.add(new Node(i, nodeinfo[i - 1][0], nodeinfo[i - 1][1]));
        }

        // y 오름차순 노드 정렬
        Collections.sort(nodeList);

        Node root = nodeList.get(0);

        if (size > 1) {
            int idx = 1, height = 0;

            while (true) {
                height = nodeList.get(idx).y;
                boolean flag = false;

                while (true) {  // 같은 높이의 노드 처리
                    if (height == nodeList.get(idx).y) {
                        initNode(root, nodeList.get(idx++));
                    } else
                        break;

                    if (idx > nodeList.size() - 1) {
                        flag = true;
                        break;
                    }
                }
                
                if(flag){
                    break;
                }
            }
        }

        search(root);

        return answer;
    }
}
