
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
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

 
}
