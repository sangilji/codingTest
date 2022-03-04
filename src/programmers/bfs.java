package programmers;

import java.util.*;

public class bfs {
    int right,bottom;
    int[][] visit;
    int[] x={1,0,-1,0} , y= {0,1,0,-1};
    public int solution(int[][] maps) {
        int answer=0;
        right = maps[0].length-1;
        bottom = maps.length-1;
        visit = new int[bottom+1][right+1];
        answer = bfs(maps);
        return answer;
    }
    public int bfs(int [][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visit[0][0] = 1;
        int count =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            while(--size >=0){
                int[] pos = queue.poll(); //현위치

                if(pos[0]==bottom && pos[1]==right){
                    return count;
                }
                for(int i =0;i<4;i++){ //하우상좌 순서
                    int newX = pos[0] + x[i];
                    int newY = pos[1] + y[i];

                    if(newX <0 || newY<0 || newX>bottom || newY>right || visit[newX][newY]==1 || maps[newX][newY]==0){
                        continue;
                    }
                    visit[newX][newY]=1;
                    queue.offer(new int[]{newX,newY});
                }

            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
