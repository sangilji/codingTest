

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] num;
    static int[] cal = new int[4];
    static List<Integer> arr = new ArrayList<>();
    static int n;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n=s.nextInt();
        num=new int[n];
        for(int i =0; i<n;i++){
            num[i] =s.nextInt();
        }
        for(int i =0; i<4;i++){
            cal[i] =s.nextInt();
        } //setting

        dfs(num[0],1);
        Collections.sort(arr);
        System.out.println(arr.get(arr.size()-1) +"\n"+ arr.get(0));
    }

    private static void dfs(int result, int depth) {

        if(n==depth){
            arr.add(result);
            return;
        }
        //더하기
        if(cal[0]>0){
            cal[0]--;
            dfs(result+num[depth],depth+1);
            cal[0]++;
        }
        //빼기
        if(cal[1]>0){
            cal[1]--;
            dfs(result-num[depth],depth+1);
            cal[1]++;
        }
        //곱하기
        if(cal[2]>0){
            cal[2]--;
            dfs(result*num[depth],depth+1);
            cal[2]++;
        }
        //나누기
        if(cal[3]>0){
            cal[3]--;
            dfs(result/num[depth],depth+1);
            cal[3]++;
        }

    }
}
