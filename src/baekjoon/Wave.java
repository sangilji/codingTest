package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wave {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long a = Long.valueOf(br.readLine());
        List<Long> arr = new ArrayList<>();
        arr.add(1L);arr.add(1L);arr.add(1L);arr.add(2L);arr.add(2L);arr.add(3L);
        arr.add(4L);arr.add(5L);arr.add(7L);arr.add(9L);
        for(int i=0;i<a;i++){
            Integer b = Integer.valueOf(br.readLine());
            if(arr.size()<b){
                for(int j = arr.size()-1;j<b;j++){
                    arr.add(arr.get(j-1)+arr.get(j-2));
                }
            }
            System.out.println(arr.get(b-1));
        }
    }
}
