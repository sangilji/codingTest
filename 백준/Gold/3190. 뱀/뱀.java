import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int[][] map = new int[n+1][n+1];
		for (int i = 0; i < k; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			map[x][y] = 1;
		}
		int l = s.nextInt();
		int[] x = new int[l];
		String[] c = new String[l];
		for(int i =0; i<l; i++){
			x[i] = s.nextInt();
			c[i] = s.next();
		}
		int time = 0;
		int current = 0;
		int direction = 0;

		Deque<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 1});
		map[1][1] = 2;

		while(!q.isEmpty()){
			time++;
			int[] currentPos = q.getLast();
			int tx = currentPos[0] + dx[direction];
			int ty = currentPos[1] + dy[direction];
			if (tx <= 0 || tx > n || ty <= 0 || ty > n || map[tx][ty] == 2) {
				System.out.println(time);
				return;
			}
			if (map[tx][ty] == 1) {
				map[tx][ty] = 2;
				q.addLast(new int[] {tx, ty});
			} else {
				map[tx][ty] = 2;
				q.addLast(new int[] {tx, ty});
				int[] tmp = q.pollFirst();
				map[tmp[0]][tmp[1]] = 0;
			}

			if(x[current] == time){
				if(c[current].equals("D")){
					direction = (direction + 1) % 4;
				} else {
					direction--;
					if (direction == -1) {
						direction = 3;
					}
				}
				current= (current+1)%l;
			}
		}

		System.out.println(time);
	}
	
}
