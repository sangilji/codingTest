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
		int[] arr = new int[11];
		for (int i = 1; i < 11; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(br.readLine());
		}
		int result =0;
		for (int i = 1; i < 11; i++) {
			if (Math.abs(arr[i] - 100) <= Math.abs(result - 100)) {
				result = arr[i];
			}
		}
		System.out.println(result);


	}





}