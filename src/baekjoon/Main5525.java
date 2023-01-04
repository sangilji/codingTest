package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5525 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        List<Integer> arr = new ArrayList<>();
        String tmp = "OI";
        String a = s.next();

        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            if (a.charAt(i) == 'I') {
                for (int j = i + 1; j < a.length() - 1; j += 2) {
                    if (a.substring(j, j + 2).equals(tmp)) {
                        count++;
                        i += 2;
                    } else {
                        break;
                    }
                }
            }
            for (int j = count; j > 0; j--) {
                arr.add(j);
            }
        }
        System.out.println(arr.stream().filter(num -> num >= n).count());
    }
}
