package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main10828 {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        int top = -1;
        int[] st = new int[10000];
        List<String> arr = new ArrayList<>();
        for(int i =0;i<n;i++){
            String tmp = s.next();
            if(tmp.equals("push")){
                arr.add(tmp);
                arr.add(s.next());
            } else {
                arr.add(tmp);
            }
        }
        int start= 0;
        while(start!=arr.size()){
            if(arr.get(start).equals("push")) {
                st[++top]=Integer.parseInt(arr.get(++start));
            } else if(arr.get(start).equals("pop")) {
                System.out.println(top!=-1 ? st[top--] : -1);
            } else if(arr.get(start).equals("size")) {
                System.out.println(top+1);
            } else if(arr.get(start).equals("empty")) {
                System.out.println(top==-1 ? 1 : 0);
            } else if(arr.get(start).equals("top")) {
                System.out.println(top!=-1 ? st[top] : -1);
            }
            start++;
        }
    }

    private static void pop() {
        if(!stack.isEmpty()){
            System.out.println(stack.pop());
        } else {
            System.out.println(-1);
        }
    }

    private static void empty() {
        if(stack.isEmpty()){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void size() {
        System.out.println(stack.size());
    }

    private static void top() {
        if(!stack.isEmpty()){
            System.out.println(stack.peek());
        } else{
            System.out.println(-1);
        }
    }

    private static void push(int s) {
        stack.add(s);
    }
}
