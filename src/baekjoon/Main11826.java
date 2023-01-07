package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main11826 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);
            if (a == b) {
                return o1 - o2;
            }
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            if (x == 0) {
                if (q.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(q.poll());
                }
                sb.append("\n");
            } else {
                q.add(x);
            }
        }
        System.out.println(sb);
    }
}
