import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> m = new HashMap<>();
		int n = Integer.parseInt(br.readLine()) * 4;
		int[] arr = {4, 6, 4, 10};
		for (int i = 0; i < n; i++) {
			int time = i % 4;
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				if (s[j].equals("-")) {
					continue;
				}
				m.put(s[j], m.getOrDefault(s[j], 0) + arr[time]);

			}
		}
		int max = -1;
		int min = 1000000;
		for (Map.Entry<String, Integer> entry : m.entrySet()) {
			String s = entry.getKey();
			Integer integer = entry.getValue();
			max = Math.max(integer, max);
			min = Math.min(integer, min);
		}
		if (max == -1) {
			System.out.println("Yes");
			return;
		}
		if (max - min > 12) {
			System.out.println("No");
			return;
		}
		System.out.println("Yes");

	}



}