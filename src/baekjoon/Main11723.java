package baekjoon;

import java.util.Scanner;

public class Main11723 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int bit = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String command = s.next();
            if (command.equals("all")) {
                bit |= ~0;
                continue;
            } else if (command.equals("empty")) {
                bit &= 0;
                continue;
            }
            int x = s.nextInt();
            if (command.equals("add")) {
                bit |= (1 << (x - 1));
            } else if (command.equals("check")) {
                if ((bit & (1 << (x - 1))) != 0) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("remove")) {
                bit = bit & ~(1 << (x - 1));
            } else if (command.equals("toggle")) {
                bit ^= (1 << (x - 1));
            }
        }
        System.out.println(sb);
    }
}
