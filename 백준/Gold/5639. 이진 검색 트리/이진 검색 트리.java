//package WEEK16.P5639;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/WEEK16/P5639/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tree tree = new Tree();

        while (true){
            String input = br.readLine();

            if(input == null || input.equals("")) break;
            // 더 이상의 input 이 존재하지 않으면 break
            int intData = Integer.parseInt(input);
            tree.createNode(intData);
        }

        tree.postOrder(tree.root);
    }

}

class Node{
    public int data;
    public Node lNode, rNode;

    public void setlNode(int data){
        this.lNode = new Node(data);
    }

    public void setrNode(int data){
        this.rNode = new Node(data);
    }

    public Node(int data){
        this.data=data;
        this.lNode=null;
        this.rNode=null;
    }
}

class Tree{
    Node root;

    //루트 노드를 생성
    void createNode(int data){
        if(root == null){
            root = new Node(data);
        } else {
            anotherNode(root,data);
        }
    }

    //루트 외 다른 노드들을 생성
    void anotherNode(Node node, int data){
        if(node.data > data){
            if(node.lNode == null) {
                node.setlNode(data);
            } else {
                anotherNode(node.lNode, data);
            }
        }
        else {
            if(node.rNode == null){
                node.setrNode(data);
            }else {
                anotherNode(node.rNode,data);
            }
        }
    }

    //후위 순회 방식으로 노드를 출력
    void postOrder (Node node){
        if(node != null){
            if(node.lNode != null)
                postOrder(node.lNode);

            if(node.rNode != null)
                postOrder(node.rNode);

            System.out.println(node.data);
        }
    }
}