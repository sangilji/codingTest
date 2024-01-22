import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int[] arr2;
    static int[][] arr1;

    static long[] tree;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        Set<Integer> s = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        arr1 = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr1[i][0] = a;
            arr1[i][1] = b;
            s.add(a - 1);
            s.add(a + 1);
            s2.add(b - 1);
            s2.add(b + 1);
        }

        List<Integer> list = s.stream().sorted().collect(Collectors.toList());
        List<Integer> list2 = s2.stream().sorted().collect(Collectors.toList());
        int start = 0;
        int end = 1;
        long result = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                int height = list.get(j) - list.get(i);
                int start2 = 0;
                int end2 = 1;
                while (end2 < list2.size()) {
                    int width = list2.get(end2) - list2.get(start2);
//                    System.out.println(list.get(i) + ":" + list.get(j) + "," + list2.get(start2) + ":" + list2.get(end2));
                    if (check(list.get(i), list.get(j), list2.get(start2), list2.get(end2))) {
                        result = Math.min((long) height * width, result);
                        start2++;
                    } else {
                        end2++;
                    }
                }
            }
        }
        System.out.println(result);

    }

    private static boolean check(int x, int x2, int y, int y2) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr1[i][0] > x && arr1[i][0] < x2 && arr1[i][1] > y && arr1[i][1] < y2) {
                count++;
            }
            if (count >= n / 2) {
                return true;
            }
        }
        return false;
    }

}