import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr1 = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int sum =0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                arr1[index++] = sum;
            }
        }
        m = Integer.parseInt(br.readLine());
        long[] b = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        long[] arr2 = new long[m * (m + 1) / 2];
        index = 0;
        for (int i = 0; i < m; i++) {
            long sum = 0 ;
            for (int j = i; j < m; j++) {
                sum += b[j];
                arr2[index++]= sum;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int start = 0;
        int last = arr2.length-1;
        long result = 0;
        while (start < arr1.length && last >= 0) {
            long tmp1 = arr1[start];
            long tmp2 = arr2[last];
            if (tmp1 + tmp2 < t) {
                start++;
            } else if (tmp1 + tmp2 > t) {
                last--;
            } else {
                int aCount = 0;
                int bCount = 0;
                while (start < arr1.length && tmp1 == arr1[start]) {
                    start++;
                    aCount++;
                }
                while (last >= 0 && tmp2 == arr2[last]) {
                    last--;
                    bCount++;
                }

                result += (long) aCount * bCount;
            }
        }
        System.out.println(result);
    }
}