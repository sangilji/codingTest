package baekjoon;

import java.util.Scanner;

public class BasuAndYaksu5086 {
    public static void main(String[] args) {
        int a,b;
        Scanner s = new Scanner(System.in);
        do{
            a=s.nextInt();
            b=s.nextInt();
            if(a==0&& b==0){
                break;
            }
            if(a%b==0){
                System.out.println("multiple");
            } else if (b%a==0) {
                System.out.println("factor");
            } else{
                System.out.println("neither");
            }
        }while(true);
    }
}
