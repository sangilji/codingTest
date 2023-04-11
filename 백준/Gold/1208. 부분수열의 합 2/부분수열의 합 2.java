import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int s;
    static int[] a;
    static int[] b;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        a = new int[n / 2];
        b = new int[n - n / 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n / 2; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - n / 2; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        dfs1(0, 0);
        dfs2(0, 0);
        list1.sort(Comparator.comparingInt(o -> o));
        list2.sort(Comparator.comparingInt(o -> o));

        int start = 0;
        int end = list2.size() - 1;
        long result = 0;
        while (start < list1.size() && end >= 0) {
            int tmp1 = list1.get(start);
            int tmp2 = list2.get(end);
            if (tmp1 + tmp2 < s) {
                start++;
            } else if (tmp1 + tmp2 > s) {
                end--;
            } else {
                int aCount = 0;
                while (start < list1.size() && tmp1 == list1.get(start)) {
                    start++;
                    aCount++;
                }
                int bCount = 0;
                while (end >= 0 && tmp2 == list2.get(end)) {
                    end--;
                    bCount++;
                }
        
                result += (long) aCount * bCount;
            }
        } //0 0 0 0
        if (s==0){
            result--;
        }
        System.out.println(result);
    }

    private static void dfs1(int sum, int count) {
        if (count == a.length) {
            list1.add(sum);
            return;
        }
        dfs1(sum + a[count], count + 1);
        dfs1(sum, count + 1);
    }

    private static void dfs2(int sum, int count) {
        if (count == b.length) {
            list2.add(sum);
            return;
        }
        dfs2(sum + b[count], count + 1);
        dfs2(sum, count + 1);
    }


}