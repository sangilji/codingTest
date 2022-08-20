package baekjoon;

import java.util.Scanner;

public class Fibonacci24416 {
    static int count1 =0;
    static int count2 =0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        n= s.nextInt();
        fib(n);
        fibonacci(n);
        System.out.println(count1+" "+ count2);
    }

    private static int fibonacci(int n) {
        int tmp=0;
        int tmp1 =1;
        int tmp2=1;
        if(n==1 || n==2){
            count2++;
            return 1;
        } else {
            for(int i =3; i<=n; i++){
                tmp=tmp1+tmp2;
                tmp1=tmp2;
                tmp2=tmp;
                count2++;
            }
            return tmp;
        }
    }

    private static int fib(int n) {
        if(n==1 || n==2) {
            count1++;
            return 1;
        } else{
            return (fib(n-1) + fib( n-2));
        }
    }
}
