import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }

        void add(int tmp) {
            if (this.value>tmp){
                if (this.left != null){
                    this.left.add(tmp);
                } else {
                    this.left = new Node(tmp);
                }
            } else {
                if (this.right != null){
                    this.right.add(tmp);
                } else {
                    this.right = new Node(tmp);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node startNode = new Node(Integer.parseInt(br.readLine()));
        String command;
        while (true){
            command = br.readLine();
            if(command==null|| command.equals("")){
                break;
            }
            int tmp = Integer.parseInt(command);

            startNode.add(tmp);
        }
        print(startNode);
        System.out.println(sb);
    }


    private static void print(Node current) {
        if (current==null){
            return;
        }
        if (current.left!=null) {
            print(current.left);
        }
        if (current.right!=null){
            print(current.right);
        }
        sb.append(current.value).append("\n");
    }
}
