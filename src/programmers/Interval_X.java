package programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Interval_X {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];
        for(int i=0;i<n;i++)
            answer[i]=x*(i+1);

        return answer;
    }
    public static void main(String[] args) {
        Interval_X I = new Interval_X();
        Scanner s = new Scanner(System.in);
        int a,b;
        a=s.nextInt();
        b=s.nextInt();
        long[] li = I.solution(a,b);
        for(long i : li){
            System.out.println(i);
        }
    }
}
