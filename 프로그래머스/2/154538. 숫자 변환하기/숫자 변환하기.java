import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[1000001];
        q.add(new int[]{x,0});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0]==y){
                return tmp[1];
            }
            if(visit[tmp[0]]){
                continue;
            }
            visit[tmp[0]] = true;
            if(tmp[0]+n<=1000000){
                q.add(new int[]{tmp[0]+n,tmp[1]+1});
            }
            if(tmp[0]*2<=1000000){
                q.add(new int[]{tmp[0]*2,tmp[1]+1});
            }
            if(tmp[0]*3<=1000000){
                q.add(new int[]{tmp[0]*3,tmp[1]+1});
            }
        }
        return -1;
    }
}