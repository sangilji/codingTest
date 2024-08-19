import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<Integer>();

        int num = Integer.parseInt(br.readLine());

        int temp = 0;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <st.countTokens() ; j++) {
                int count = stack.size();
                String tempStr = st.nextToken();
                if(tempStr.equals("push")){
                    temp = Integer.parseInt((st.nextToken()));
                    stack.add(temp);
                } else if(tempStr.equals("pop")){
                    if(count > 0){
                        System.out.println(stack.pop());
                    } else {
                        System.out.println(-1);
                    }
                } else if (tempStr.equals("size")){
                    System.out.println(stack.size());
                } else if (tempStr.equals("empty")) {
                    if(stack.empty()){
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                } else if(tempStr.equals("top")){
                    if(count > 0){
                        System.out.println(stack.peek());
                    } else {
                        System.out.println(-1);
                    }
                }
            }

        }
    }
}