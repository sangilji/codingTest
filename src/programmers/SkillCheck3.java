package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class SkillCheck3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = new String[]{"ba", "na", "n", "a"};
        String t = "banana";
        solution.solution(arr, t);


    }

    static class Solution {
        public int solution(String[] strs, String t) {
            int answer = 0;

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            answer = bfs(strs, t);
            return answer;
        }

        public int bfs(String[] strs, String t) {
            Queue<Object[]> q = new LinkedList<>();
            q.add(new Object[]{"", 0, 0});
            while (!q.isEmpty()) {
                Object[] o = q.poll();
                System.out.println(o[0] + ":" + o[1] + ":" + o[2]);
                if (o[0].equals(t)) {
                    return (int) o[1];
                }
                for (int i = 0; i < strs.length; i++) {
                    if ((int) o[2] + strs[i].length() <= t.length() && strs[i].equals(t.substring((int) o[2], (int) o[2] + strs[i].length()))) {
                        q.add(new Object[]{o[0] + strs[i], (int) o[1] + 1, (int) o[2] + strs[i].length()});
                    }
                }
            }
            return -1;
        }
    }
}
