import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0]-o2[0];
        });

        int result = 0 ;
        int i = 0;
        while (i < n) {
            int start = arr[i][0];
            int last = arr[i][1];
            while (i + 1 < n) {
                if (last<arr[i+1][0]){
                    break;
                }
                last = Math.max(last,arr[i + 1][1]);
                i++;
            }
            result+= last-start;
            i++;
        }
        System.out.println(result);

    }

}