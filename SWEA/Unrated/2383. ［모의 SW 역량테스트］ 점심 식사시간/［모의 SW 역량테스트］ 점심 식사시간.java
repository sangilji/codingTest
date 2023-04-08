import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n;
    static int[][] map;
    static List<int[]> entrance;
    static List<int[]> person;
    static int[] selectedEntrance;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            min = 100;
            map = new int[n][n];
            entrance = new ArrayList<>();
            person = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        person.add(new int[]{i, j});
                    }
                    if (map[i][j] > 1) {
                        entrance.add(new int[]{i, j});
                    }
                }
            }
            selectedEntrance = new int[person.size()];
            dfs(0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int depth) {
        if (person.size() == depth) {
            findMin();
            return;
        }

        selectedEntrance[depth] = 1;
        dfs(depth + 1);
        selectedEntrance[depth] = 0;
        dfs(depth + 1);
    }

    private static void findMin() {
        int max = 0;
        for (int i = 0; i < 2; i++) {
            int[] ent = entrance.get(i);
            int entV = map[ent[0]][ent[1]];
            PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(o -> o));
            for (int j = 0; j < person.size(); j++) {
                if (selectedEntrance[j] == i) {
                    int[] p = person.get(j);
                    q.add(Math.abs(p[0] - ent[0]) + Math.abs(p[1] - ent[1]) + 1);
                }
            }

            int[] time = new int[100];
            int end = 0;
            while (!q.isEmpty()) {
                int tmp = q.poll();
                int start = tmp;
                end = start + entV;
                for (int j = start; j < end; j++) {
                    if (time[j] == 3) {
                        end++;
                        continue;
                    }
                    time[j]++;
                }
            }
            max = Math.max(max, end);
        }
        min = Math.min(max, min);

    }
}