import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] alphabet = new int[4];
    static int[] password;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String tmp = br.readLine();

        password = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int count = 0;

        key(tmp, 0, p);
        count += check();
        for (int i = 0; i < s - p; i++) {
            int j = counting(tmp.charAt(i));
            if (j >= 0) {
                alphabet[j]--;
            }
            j = counting(tmp.charAt(i + p));
            if (j >= 0) {
                alphabet[j]++;
            }
            count += check();
        }
        System.out.println(count);
    }

    private static int check() {
        for (int i = 0; i < 4; i++) {
            if (password[i] > alphabet[i]) {
                return 0;
            }
        }
        return 1;
    }

    private static void key(String key, int start, int end) {
        {
            char[] charArray = key.toCharArray();
            for (int i = start; i < end; i++) {
                int tmp = counting(charArray[i]);
                if (tmp >= 0) {
                    alphabet[tmp]++;
                }
            }
        }
    }

    private static int counting(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        } else if (c == 'T') {
            return 3;
        }
        return -1;
    }
}