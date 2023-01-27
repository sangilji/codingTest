import java.util.*;
import java.util.stream.Collectors;

class Solution {
   public int solution(int[] food_times, long k) {
        long answer = 0;
        if(Arrays.stream(food_times).mapToLong(n->n).sum()<=k){
            return -1;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        for(int i = 0; i<food_times.length;i++ ){
            q.add(new int[]{i,food_times[i]});
        }
        long count = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[1]<=count){
                continue;
            }
            long tmpValue =(tmp[1] - count) *(q.size()+1);
            if(answer + tmpValue >k){
                q.add(tmp);
                break;
            }
            answer+= tmpValue;
            count= tmp[1];
        }
        List<Integer> arr = q.stream().map(n -> n[0]).sorted().collect(Collectors.toList());
         if(answer!=0){
            return arr.get((int)(k-answer)%arr.size()) + 1;
        }
        return arr.get((int) (((k%arr.size()) -(answer%arr.size()))%arr.size())) +1;
    }
}