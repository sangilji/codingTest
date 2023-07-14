import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] sosu;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        init();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int size = sosu[n].size();
            int result  = 0;
            for (int j = 2; j < n; j++) {
                if (size==0){
                    break;
                }
                if (sosu[j].size() == size && sosu[j].get(0)>= m) {
                    result++;
                }
            }
            sb.append("Case #").append(i+1).append(": ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void init(){
        sosu = new List[1000001];
        for (int i = 2; i < sosu.length; i++) {
            sosu[i] = new ArrayList<>();
        }
        for (int i = 2; i <= sosu.length ; i++) {
            for (int j = 2; j*i < sosu.length; j++) {
                sosu[j*i].add(i);
            }
        }
    };
}