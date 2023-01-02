package baekjoon;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main1764 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.next(), 1);
        }
        for (int i = 0; i < m; i++) {
            String name = s.next();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        List<String> arr = map.entrySet()
                .stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(arr.size());
        for (String i : arr) {
            System.out.println(i);
        }
    }
}
