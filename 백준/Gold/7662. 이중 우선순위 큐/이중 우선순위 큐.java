import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                String command = s.next();
                int num = s.nextInt();
                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (!map.isEmpty()) {
                        if (num == -1) {
                            int firstKey = map.firstKey();
                            int minKey = map.get(firstKey);
                            if (minKey == 1) {
                                map.remove(firstKey);
                            } else {
                                map.put(firstKey, minKey - 1);
                            }
                        } else {
                            int lastKey = map.lastKey();
                            int maxKey = map.get(lastKey);
                            if (maxKey == 1) {
                                map.remove(lastKey);
                            } else {
                                map.put(lastKey, maxKey - 1);
                            }
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }

}
