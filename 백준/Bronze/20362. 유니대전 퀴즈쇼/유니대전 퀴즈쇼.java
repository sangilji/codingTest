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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String name = st.nextToken();
		String[][] chat = new String[n][2];
		int idx = -1;
		String answer = "";
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				chat[i][j] = st.nextToken();
			}
			if (chat[i][0].equals(name)) {
				idx = i;
				answer = chat[i][1];
			}
		}
		int count = 0;
		for (int i = 0; i < idx; i++) {
			if (chat[i][1].equals(answer)) {
				count++;
			}
		}
		System.out.println(count);


	}



}