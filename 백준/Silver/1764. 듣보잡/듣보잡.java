import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String , String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(),"");
        }
        int count = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if (map.containsKey(tmp)) {
                count++;
                list.add(tmp);
            }
        }
        list.sort(String::compareTo);
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }


}