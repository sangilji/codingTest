import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int d = read();
        int k = read();
        int c = read();
        int[] visit = new int[d + 1];
        int[] arr = new int[n + k - 1];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
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

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        // 내가 추가.
        if (c == 13)
            System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
        return n;
    }
}