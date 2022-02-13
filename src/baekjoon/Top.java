package baekjoon;
import java.util.*;
import java.io.*;
public class Top {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> s = new Stack<>();
        for(int i = 0;i<a;i++){
            int[] tmp = {i,Integer.parseInt(st.nextToken())};
            if(s.empty()) {
                s.add(tmp);
                System.out.print(0 + " ");
            }
            else {
                while (s.peek()[1] < tmp[1]) {
                    s.pop();
                    if(s.empty())
                        break;

                }
                if(s.empty())
                    System.out.print(0+ " ");
                else
                    System.out.print(s.peek()[0]+1+" ");
                s.add(tmp);

            }
        }

    }
}
