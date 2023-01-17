import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c=-1;
        ArrayList<Integer> arr =new ArrayList<>();
        System.out.print("<");
        for(int i =1;i<=a;i++)
            arr.add(i);
        while(arr.size()!=1) {
            c = (c + b) % arr.size();
            System.out.print(arr.get(c) + ", ");
            arr.remove(c);
            c--;
        }
        System.out.print(arr.get(0)+">");
    }
}
