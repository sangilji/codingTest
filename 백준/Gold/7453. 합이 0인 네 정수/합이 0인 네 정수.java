import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        int idx = 0;
        for (Integer tmp : arr[0]) {
            for (Integer tmp1 : arr[1]) {
                ab[idx++] = tmp + tmp1;
            }
        }

        idx = 0;
        for (Integer tmp : arr[2]) {
            for (Integer tmp1 : arr[3]) {
                cd[idx++] = tmp + tmp1;
            }
        }

        Arrays.sort(cd);
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int start = 0; start < n * n; start++) {
            int a = ab[start];
            int b = Arrays.binarySearch(cd, -a);
            if (b >= 0) {
                if (map.containsKey(-a)){
                    count += map.get(-a);
                    continue;
                }
                int bCount = 0;
                for (int i = b; i >= 0; i--) {
                    if (-a == cd[i]) {
                        bCount++;
                    } else {
                        break;
                    }
                }
                for (int i = b+1; i < n*n; i++) {
                    if (-a == cd[i]) {
                        bCount++;
                    } else {
                        break;
                    }
                }
                map.put(-a, bCount);
                count += bCount;
            }
        }

        System.out.println(count);
    }
}