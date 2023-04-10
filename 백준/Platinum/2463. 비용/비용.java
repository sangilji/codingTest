import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        counts = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }
        long sum = 0;
        int[][] nodes = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                nodes[i][j] = Integer.parseInt(st.nextToken());
            }
            if (nodes[i][0] > nodes[i][1]) {
                int tmp = nodes[i][0];
                nodes[i][0] = nodes[i][1];
                nodes[i][1] = tmp;
            }
            sum += nodes[i][2];
        }
        Arrays.sort(nodes, (o1, o2) -> o2[2] - o1[2]);
        Arrays.fill(counts, 1);
        long result = 0;
        for (int i = 0; i < m; i++) {
            int a = find(nodes[i][0]);
            int b = find(nodes[i][1]);
            if (a != b) {
                parents[b] = a;
                result += (sum % 1_000_000_000 * ((long) counts[a] * counts[b])) % 1_000_000_000;
                counts[a] += counts[b];
                counts[b] = 0;
            }
            result%=1_000_000_000;
            sum -= nodes[i][2];
        }

        System.out.println(result);
    }

    private static int find(int i) {
        if (parents[i] == i) {
            return i;
        }
        return parents[i] = find(parents[i]);
    }
}