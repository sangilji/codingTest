import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {
    static String[] s1;
    static String[] s2;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList[n + 1];
            for (int j = 0; j < n + 1; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < n - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[b].add(a);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            find(a,0, "");
            find(b,1, "");
            String result ="";
            for (int j = s1.length-1,k = s2.length-1 ;j >=0 &&k>=0 ; j--,k--) {
                if (s1[j].equals(s2[k])){
                    result = s1[j];
                } else{
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

    private static void find(int a,int num, String nodes) {
        nodes+=a+" ";
        if (list[a].size()==0){
            if (num ==0) {
                s1 = nodes.split(" ");
            }
            else{
                s2 = nodes.split(" ");
            }
            return;
        }
        for (int i = 0; i < list[a].size(); i++) {
            find(list[a].get(i),num,nodes);
        }
    }
}
