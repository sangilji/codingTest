import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count = 0;
	static int n;
	static int m;
	static int x;
	static int y;
	static int t;
	static int d;
	static int k;
	static int[][] arr;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		x = n / 2 + 1;
		y = n / 2 + 1;
		int start = 1;
		int increment = 0;
		d = 0;
		while (x != 1 || y != 1) {
			if (increment != 0 && increment % 2 == 0) {
				start += 1;
			}
			increment++;
			move(start);
			d = (d + 1) % 4;
		}
		System.out.println(count);
	}

	private static void move(int start) {
		for (int i = 0; i < start; i++) {
			if (x == 1 && y == 1) {
				break;
			}
			x = x + dx[d];
			y = y + dy[d];
			if (arr[x][y] == 0) {
				continue;
			}
			spread();

		}
	}

	static int[][] oneX = {{-1, 1}, {-1, -1}, {-1, 1}, {1, 1}};
	static int[][] oneY = {{1, 1}, {-1, 1}, {-1, -1}, {-1, 1}};
	static int[][] twoX = {{-2, 2}, {0, 0}, {-2, 2}, {0, 0}};
	static int[][] twoY = {{0, 0}, {-2, 2}, {0, 0}, {-2, 2}};
	static int[][] sevenX = {{-1, 1}, {0, 0}, {-1, 1}, {0, 0}};
	static int[][] sevenY = {{0, 0}, {-1, 1}, {0, 0}, {-1, 1}};
	static int[][] tenX = {{-1, 1}, {1, 1}, {-1, 1}, {-1, -1}};
	static int[][] tenY = {{-1, -1}, {-1, 1}, {1, 1}, {-1, 1}};

	static int[][] fiveX = {{0}, {2}, {0}, {-2}};
	static int[][] fiveY = {{-2}, {0}, {2}, {0}};
	static int[][] alphaX = {{0}, {1}, {0}, {-1}};
	static int[][] alphaY = {{-1}, {0}, {1}, {0}};

	private static void spread() {
		int one = (int)(arr[x][y] * 0.01f);
		spreadPoint(oneX, oneY, one);
		int two = (int)(arr[x][y] * 0.02f);
		spreadPoint(twoX, twoY, two);
		int seven = (int)(arr[x][y] * 0.07f);
		spreadPoint(sevenX, sevenY, seven);
		int ten = (int)(arr[x][y] * 0.1f);
		spreadPoint(tenX, tenY, ten);
		int five = (int)(arr[x][y] * 0.05f);
		spreadPoint(fiveX, fiveY, five);

		int alpha = arr[x][y] - (one + two + seven + ten) * 2 - five;
		spreadAlpha(alpha);
	}

	private static void spreadAlpha(int v) {
		int tx = x + alphaX[d][0];
		int ty = y + alphaY[d][0];
		arr[x][y] = 0;
		if (tx <= 0 || ty <= 0 || tx > n || ty > n) {
			count += v;
			return;
		}
		arr[tx][ty] += v;

	}

	private static void spreadPoint(int[][] tmpX, int[][] tmpY, int v) {
		for (int i = 0; i < tmpX[d].length; i++) {
			int tx = x + tmpX[d][i];
			int ty = y + tmpY[d][i];
			if (tx <= 0 || ty <= 0 || tx > n || ty > n) {
				count += v;
				continue;
			}
			arr[tx][ty] += v;
		}
	}

}