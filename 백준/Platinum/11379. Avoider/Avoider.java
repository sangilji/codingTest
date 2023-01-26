import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
		long[] counts = new long[]{0, 1, 2, 5, 12, 30, 73, 183, 456, 1151, 2900, 7361, 18684, 47652, 121584, 311259, 797311, 2047384, 5260692, 13542718, 34884239, 89991344, 232282110, 600281932, 1552096361, 4_017_128_206L, 10_401_997_092L, 26_957_667_445L, 69_892_976_538L};
		//코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		long sum = 0;
		for (int i = a; i <=b ; i++) {
			sum+=counts[i];
		}
		System.out.println(sum);

    }

}

