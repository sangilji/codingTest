
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Map<String, Integer> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st  = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i< n;i++){
			String num = st.nextToken();
			map.put(num,map.getOrDefault(num,0)+1);
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<m;i++){
			String num = st.nextToken();
			sb.append(map.getOrDefault(num,0)).append(" ");
		}
		System.out.println(sb);
		br.close();
	}


}
