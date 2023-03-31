import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int[] arr;
    static int[] dp;
    static int[] dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int size = Arrays.stream(dp).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");
        int[] answer = new int[size];
        int index = size;
        for (int i = n; i > 0; i--) {
            if (dp[i] == index) {
                index--;
                answer[index] = arr[i];
            }
            if (index == 0) {
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            sb.append(answer[i]).append(" ");
        }
        
        System.out.println(sb);
    }

    private static int search(int size, int target) {
        int left = 0;
        int right = size;
        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}