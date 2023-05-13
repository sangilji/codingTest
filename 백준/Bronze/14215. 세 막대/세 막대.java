import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        
        if(input[0] + input[1]> input[2]){
            System.out.println(input[0]+input[1]+input[2]);
        } else {
            System.out.println((input[0]+input[1])*2 -1);
        }
    }
}