package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Cutline {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int[] c = new int[a];
        for(int i =0;i<a;i++){
            c[i]=s.nextInt();
        }
        Arrays.sort(c);
        System.out.println(c[c.length-b]);
    }
}
