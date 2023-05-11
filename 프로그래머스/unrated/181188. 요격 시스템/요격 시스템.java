import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1,o2) ->{
            if(o1[0]== o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0] - o2[0];
        });
        int tmp = targets[0][1];
        // System.out.println(Arrays.deepToString(targets));
        for(int i = 1 ; i < targets.length; i++){
            if(tmp>targets[i][0]){
                tmp = Math.min(tmp,targets[i][1]);
                continue;
            }
            tmp = targets[i][1];
            answer++;
        }
        return answer;
    }
}