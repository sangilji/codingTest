import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        switches = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(br.readLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (tmp[0] == 1) {
                man(tmp[1]);
            } else {
                woman(tmp[1]);
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i]+" ");
            if (i%20==0){
                System.out.println();
            }
        }
    }

    private static void woman(int i) {
        int count = 1;
        while(true){
            if (i-count>0 && i+count< switches.length){
                if (switches[i-count] == switches[i+count]) {
                    count++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        count--;
        for (int j = i-count; j <= i+count ; j++) {
            switches[j] = (switches[j] + 1) % 2;
        }
    }

    private static void man(int i) {
        int mul = i;
        while (switches.length > mul) {
            switches[mul] = (switches[mul] + 1) % 2;
            mul+=i;
        }
    }
}