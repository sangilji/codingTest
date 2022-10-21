package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCard {
    static int[] card;
    static int n;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        card = new int[n];
        for(int i =0; i<n;i++){
            card[i]=s.nextInt();
        }
        Arrays.sort(card);
        int a =s.nextInt();
        for(int i =0;i<a;i++){
            int num=s.nextInt();
            search(num);
        }
    }

    private static void search(int num) {
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid = (left+right)/2;
            int m = card[mid];

            if(num < m){
                right = mid -1;
            } else if(num > m){
                left = mid+1;
            } else {
                System.out.print("1 ");
                return;
            }
        }
        System.out.print("0 ");
        
    }
}
