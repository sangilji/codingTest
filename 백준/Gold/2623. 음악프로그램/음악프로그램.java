import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] count = new int[n + 1];
        ArrayList<Integer>[] order = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            order[i] = new ArrayList<>();
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < tmp.length-1; j++) {
                order[tmp[j]].add(tmp[j+1]);
                count[tmp[j + 1]]++;
            }
        }
        for (int i = 1; i < n+1; i++) {
            if (count[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int tmp = q.poll();
            sb.append(tmp).append("\n");
            for (Integer i : order[tmp]){
                count[i]--;
                if (count[i] == 0) {
                    q.add(i);
                }
            }
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb);
    }


}