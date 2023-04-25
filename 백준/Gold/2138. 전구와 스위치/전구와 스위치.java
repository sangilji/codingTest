import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] current;
    static int[] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        current = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] tmp = current.clone();
        tmp[0] = (tmp[0] + 1) % 2;
        tmp[1] = (tmp[1] + 1) % 2;
        result = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int min;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (current[i - 1] != result[i - 1]) {
                current[i - 1] = (current[i - 1] + 1) % 2;
                current[i] = (current[i] + 1) % 2;
                current[i + 1] = (current[i + 1] + 1) % 2;
                count++;
            }
        }
        if (current[n - 2] != result[n - 2]) {
            if (current[n - 1] != result[n - 1]) {
                count++;
            }else{
                count=-1;
            }
        } else {
            if (current[n - 1] != result[n - 1]) {
                count = -1;
            }
        }
        min = count;
        count = 1;
        for (int i = 1; i < n - 1; i++) {
            if (tmp[i - 1] != result[i - 1]) {
                tmp[i - 1] = (tmp[i - 1] + 1) % 2;
                tmp[i] = (tmp[i] + 1) % 2;
                tmp[i + 1] = (tmp[i + 1] + 1) % 2;
                count++;
            }
        }
        if (tmp[n - 2] != result[n - 2]) {
            if (tmp[n - 1] != result[n - 1]) {
                count++;
            } else {
                count=-1;
            }
        } else {
            if (tmp[n - 1] != tmp[n - 1]) {
                count = -1;
            }
        }
        if (min == -1) {
            System.out.println(count);
        } else{
            System.out.println(min);
        }
    }


}