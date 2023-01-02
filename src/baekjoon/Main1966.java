package baekjoon;

import java.util.*;

public class Main1966 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            Queue<int[]> q = new LinkedList<>();
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int tmp = s.nextInt();
                q.add(new int[]{j, tmp});
                arr.add(tmp);
            }
            arr.sort((o1, o2) -> o2 - o1);
            int count = 1;
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                if (tmp[1] == arr.get(0)) {
                    if (tmp[0] == m) {
                        System.out.println(count);
                        break;
                    } else {
                        count++;
                        arr.remove(0);
                    }
                } else {
                    q.add(tmp);
                }
            }
        }
    }
}
