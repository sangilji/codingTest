package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumberTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        int n = s.nextInt();
        for(int i =0;i<n;i++){
            list.add(new int[i+1]);
            for(int j=0;j<i+1;j++){
                list.get(i)[j]=s.nextInt();
            }
        }
        for(int i =1;i<n;i++){
            list.get(i)[0]+=list.get(i-1)[0];
            list.get(i)[i]+= list.get(i-1)[i-1];
        }
        for(int i =2;i<n;i++){
            for(int j=1; j<i;j++){
                list.get(i)[j]+=Math.max(list.get(i-1)[j-1],list.get(i-1)[j]);
            }
        }
        System.out.println(Arrays.stream(list.get(n-1)).max().getAsInt());
    }
}
