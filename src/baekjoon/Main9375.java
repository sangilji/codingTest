package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main9375 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String value = s.next();
                String key = s.next();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int result = 1;
            for (String j : map.keySet()) {
                result = result * (map.get(j) + 1);
            }
            System.out.println(result - 1);
        }
    }
}
