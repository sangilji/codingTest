import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int count = 0;

            for (int j = 2; j <= 20; j++) {
                for (int k = 1; k <= j - 1; k++) {
                    if (arr[k] > arr[j]) {
                        int tmp = arr[j];
                        for (int l = j; l > k; l--) {
                            arr[l] = arr[l - 1];
                            count++;
                        }
                        arr[k] = tmp;
                        break;
                    }
                }
            }
            sb.append(i + 1).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}