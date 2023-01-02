package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> arr = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String monster = br.readLine();
            map.put(monster, i + 1);
            arr.put(i + 1, monster);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            if (command.matches("^[0-9]*$")) {
                sb.append(arr.get(Integer.parseInt(command))).append("\n");
            } else {
                sb.append(map.get(command)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
