import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<int[]> s = new Stack<>();
        String[] r = new String[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                s.add(new int[]{arr[i],i});
            } else {
                while (!s.isEmpty() && s.peek()[0] < arr[i]) {
                    int[] tmp = s.pop();
                    r[tmp[1]] = String.valueOf(i+1);
                }
                s.add(new int[]{arr[i],i});
            }
        }
        while (!s.isEmpty()) {
            int[] tmp = s.pop();
            r[tmp[1]] = String.valueOf(0);
        }

        System.out.println(String.join(" ",r));
    }
}