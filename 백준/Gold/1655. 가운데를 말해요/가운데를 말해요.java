import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sort(arr, tmp, i);
        }
        System.out.println(sb);

    }

    private static void sort(List<Integer> arr, int tmp, int i) {
        if (arr.isEmpty()) {
            arr.add(tmp);
            sb.append(tmp).append("\n");
            return;
        }
        int left = 0;
        int right = i;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;

            if (arr.get(mid) > tmp) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        arr.add(right, tmp);
        int a = arr.get((i + 1) / 2);
        if ((i+1) % 2 == 0) {
            sb.append(Math.min(a,arr.get((i + 1) / 2 - 1))).append("\n");
        } else {
            sb.append(a).append("\n");
        }
    }

}