package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main11399 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum = 0;
        int result = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(s.nextInt());
        }
        while (!q.isEmpty()) {
            sum += q.poll();
            result += sum;
        }
        System.out.println(result);
    }
}
