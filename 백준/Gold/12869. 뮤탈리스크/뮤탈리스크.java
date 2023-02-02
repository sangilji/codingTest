import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scv = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }
        if (n == 1) {
            System.out.println(scv[0] % 9 == 0 ? scv[0] / 9 : scv[0] / 9 + 1);
            return;
        }

        scv[n] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[n] == o2[n]) {
                return Arrays.stream(o1).sum() - Arrays.stream(o2).sum();
            }
            return o1[n] - o2[n];
        });
        q.add(scv);

        if (n == 2) {
            boolean[][] visit = new boolean[61][61];
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                if (visit[tmp[0]][tmp[1]]) {
                    continue;
                }
                visit[tmp[0]][tmp[1]] = true;
                if (visit[0][0]) {
                    System.out.println(tmp[n]);
                    break;
                }
                int a;
                int b;

                a = Math.max(tmp[0] - 9, 0);
                b = Math.max(tmp[1] - 3, 0);
                q.add(new int[]{a, b, tmp[2] + 1});
                a = Math.max(tmp[0] - 3, 0);
                b = Math.max(tmp[1] - 9, 0);
                q.add(new int[]{a, b, tmp[2] + 1});

            }
        } else {
            boolean[][][] visit = new boolean[61][61][61];
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
               
                if (visit[tmp[0]][tmp[1]][tmp[2]]) {
                    continue;
                }
                visit[tmp[0]][tmp[1]][tmp[2]] = true;
                if (visit[0][0][0]) {
                    System.out.println(tmp[n]);
                    break;
                }
                int a;
                int b;
                int c;

                a = Math.max(tmp[0] - 9, 0);
                b = Math.max(tmp[1] - 3, 0);
                c = Math.max(tmp[2] - 1, 0);
                q.add(new int[]{a, b, c, tmp[3] + 1});
                a = Math.max(tmp[0] - 3, 0);
                b = Math.max(tmp[1] - 1, 0);
                c = Math.max(tmp[2] - 9, 0);
                q.add(new int[]{a, b, c, tmp[3] + 1});
                a = Math.max(tmp[0] - 9, 0);
                b = Math.max(tmp[1] - 1, 0);
                c = Math.max(tmp[2] - 3, 0);
                q.add(new int[]{a, b, c, tmp[3] + 1});
                a = Math.max(tmp[0] - 3, 0);
                b = Math.max(tmp[1] - 9, 0);
                c = Math.max(tmp[2] - 1, 0);
                q.add(new int[]{a, b, c, tmp[3] + 1});
                a = Math.max(tmp[0] - 1, 0);
                b = Math.max(tmp[1] - 3, 0);
                c = Math.max(tmp[2] - 9, 0);
                q.add(new int[]{a, b, c, tmp[3] + 1});
                a = Math.max(tmp[0] - 1, 0);
                b = Math.max(tmp[1] - 9, 0);
                c = Math.max(tmp[2] - 3, 0);
                q.add(new int[]{a, b, c, tmp[3] + 1});

            }
        }

    }

}
