import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 1; i <= 500; i++) {
			for (int j = 1; j <= 500; j++) {
				if (i * i == j * j + n) {
					count++;
				}
			}
		}
		System.out.println(count);

	}





}