import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] ants = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            ants[i][0] = Integer.parseInt(br.readLine());
            ants[i][1] = i;
        }
        int leftAnt = 0;
        int leftCount = 0;
        int rightAnt = 0;
        for (int i = 1; i < n+1; i++) {
            if (ants[i][0] < 0) {
                if (leftAnt<ants[i][0]*-1){
                    leftAnt = ants[i][0]*-1;
                }
                leftCount++;
            } else {
                if (rightAnt<l-ants[i][0]){
                    rightAnt = l-ants[i][0];
                }
            }
        }
        Arrays.sort(ants, Comparator.comparingInt(o -> Math.abs(o[0])));

        if (leftAnt < rightAnt) {
            System.out.println(ants[leftCount+1][1] +" " + rightAnt);
        } else {
            System.out.println(ants[leftCount][1] +" " + leftAnt);
        }
    }


}