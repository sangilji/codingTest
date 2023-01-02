package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1759 {
    static boolean[] visit;
    static String[] alphabet;
    static int L;
    static int C;
    static List<String> keys = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        L = s.nextInt();
        C = s.nextInt();
        alphabet = new String[C];
        visit = new boolean[C];
        for (int i = 0; i < C; i++) {
            alphabet[i] = s.next();
        }
        Arrays.sort(alphabet);
        dfs(0, "", 0);
        for (String i : keys) {
            System.out.println(i);
        }
    }

    private static void dfs(int depth, String key, int start) {
        if (depth == L) {
            validateKey(key);
            return;
        }
        for (int i = start; i < alphabet.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(depth + 1, key + alphabet[i], i + 1);
            visit[i] = false;
        }
    }

    private static void validateKey(String key) {
        int a = 0;
        int b = 0;
        for (String s : key.split("")) {
            if (s.matches("[aeiou]")) {
                a++;
            } else {
                b++;
            }
        }
        if (a >= 1 && b >= 2) {
            keys.add(key);
        }
    }
}
