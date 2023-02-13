import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<String> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(String.valueOf(i));
        }

        int start = -1;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            start = (start+k) % (n-i);
            result.add(arr.remove(start));
            start--;
        }
        System.out.printf("<%s>%n", String.join(", ", result));

    }
}