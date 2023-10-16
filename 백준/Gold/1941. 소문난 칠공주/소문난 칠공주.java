import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int k;
	static int m;

	static String[][] arr;
	static boolean[][] visit;
	static int[] dx = {0,-1, 0,1};
	static int[] dy = {-1,0, 1,0};

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new String[5][5];
		visit = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().split("");
		}

		recur(0, 0, 0);

		System.out.println(max);
	}
	static int max =0;

	private static void recur(int x, int y,int count) {
		if (y >= 5) {
			y=0;
			x+=1;
		}
		if (x >= 5 || count >= 7) {
			if (count != 7) {
				return;
			}
			boolean b = false;
			int tmp = 0;
			for (int i = 0; i < 5; i++) {
				if (b) {
					break;
				}
				for (int j = 0; j < 5; j++) {
					if (visit[i][j]) {
						tmp = recur2(i, j,new boolean[5][5]);
						b= true;
						break;
					}
				}
			}
			int min = 0;
			if (tmp != 7) {
				return;
			}
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (visit[i][j] && arr[i][j].equals("S")) {
						min++;
					}
				}
			}
			if (min < 4) {
				return;
			}
			max++;
			return;
		}

		visit[x][y]=true;
		recur(x, y + 1, count + 1);
		visit[x][y] = false;
		recur(x, y + 1, count);


	}

	private static int recur2(int x, int y,boolean[][] tmp) {
		int count = 1;
		tmp[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if (tx < 0 || ty < 0 || tx >= 5 || ty >= 5 || !visit[tx][ty]||tmp[tx][ty]) {
				continue;
			}
			count += recur2(tx, ty, tmp);
		}
		return count;
	}

}