import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] visit = new int[d + 1];
        int[] arr = new int[n + k - 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i < n + k - 1; i++) {
            arr[i] = arr[i - n];
        }
        int result;
        int count = 0;
        for (int i = 0; i < k; i++) {
            visit[arr[i]]++;
            if (visit[arr[i]] == 1) {
                count++;
            }
        }
        visit[c]++;
        if (visit[c] == 1) {
            count++;
        }
        result = count;
        for (int i = k; i < arr.length; i++) {
            int first = arr[i - k];
            int last = arr[i];
            visit[first]--;
            if (visit[first] == 0) {
                count--;
            }
            visit[last]++;
            if (visit[last] == 1) {
                count++;
                result = Math.max(result, count);
            }
        }
        System.out.println(result);
    }
}