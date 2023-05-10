import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());
        int start = 0;
        int last =n-1;
        int result = 0;
        while (start < last) {
            int a = arr[start];
            int b = arr[last];

            if (a+b < x) {
                start++;
            } else if (a+b>x){
                last--;
            } else {
                start++;
                last--;
                result++;
            }
        }
        System.out.println(result);
    }

}