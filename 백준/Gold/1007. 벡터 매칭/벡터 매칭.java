import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static double min;
    static int[][] pos;
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            min = Double.MAX_VALUE;
            int n = Integer.parseInt(br.readLine());
            pos = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                pos[j][0] = a;
                pos[j][1] = b;
            }
            dfs(0, 0, n-1,0);
            System.out.println(min);
        }

    }
    
    private static void dfs(long x, long y, int idx, int count) {
        if (idx==-1){
            if (count==0) {
                min = Math.min(min, Math.sqrt((x * x + y * y)));
            }
            return;
        }

        dfs(x+pos[idx][0],y+pos[idx][1],idx-1,count+1);
        dfs(x-pos[idx][0],y-pos[idx][1],idx-1,count-1);
    }


}

