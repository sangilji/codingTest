package baekjoon;

import java.util.Scanner;

public class Fibonacci {
    static int countZero=0;
    static int countOne=0;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t= scan.nextInt();
        for(int i =0;i<t;i++){
            fibonacci(scan.nextInt());
            System.out.println(countZero+" "+countOne);
            countOne  = countZero =0;
        }

    }

    private static int fibonacci(int n) {
        if(n==0){
            countZero++;
            return 0;
        } else if( n== 1) {
            countOne++;
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci( n-2);
        }

    }

}
