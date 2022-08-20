package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class SamsungSWTest2 {
    static int[][] stat;
    static int min=100;
    static int n;
    static int[] member;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        n= s.nextInt();
        member = new int[n];
        Arrays.fill(member,1);
        stat = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j=0; j<n;j++){
                stat[i][j] = s.nextInt();
            }
        }//setting
        dfs(0,0);
        System.out.println(min);
    }

    private static void dfs(int depth,int start) {

        int tmp=0;
        int tmp1=0;
        int i;
        if(depth==n/2){
            min=Math.min(min,scoreSum());
            return;
        }

        for(i =start;i<member.length;i++){
            if(member[i]>0){
                tmp=0;
                tmp1=0;
                member[i]--;
                dfs(depth+1,i);
                member[i]++;
            }
        }
    }

    private static int scoreSum() {
        int team1=0;
        int team2=0;
        for(int i =0;i<member.length;i++){
            if(member[i]==0) {
                for (int j = i + 1; j < member.length; j++) {
                    if(member[j]==0){
                        team1+=stat[i][j];
                        team1+=stat[j][i];
                    }
                }
            } else {
                for (int j = i + 1; j < member.length; j++) {
                    if(member[j]==1){
                        team2+=stat[i][j];
                        team2+=stat[j][i];
                    }
                }
            }
        }
        return Math.abs(team1-team2);
    }
}
