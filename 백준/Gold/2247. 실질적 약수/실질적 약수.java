import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int MOD = 1_000_000;
	static long n;
	static long m;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Long.parseLong(br.readLine());
		long tmp = n;
		long result = 0;
		for (int i = 2; i <=n/2; i++) {
			result = (result + (i*(n/i -1))%MOD)%MOD;
		}
		System.out.println(result);
	}



}