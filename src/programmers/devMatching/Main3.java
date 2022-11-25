package programmers.devMatching;

public class Main3 {
	int[][] numbers;

	public int[] solution(int rows, int columns, int[][] queries) {
		numbers = new int[rows][columns];
		int[] answer = new int[queries.length];
		int count = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				numbers[i][j] = count++;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			answer[i]=rotation(queries[i]);
		}
		return answer;
	}

	private int rotation(int[] query) {
		int x1 = query[0]-1;
		int y1 = query[1]-1;
		int x2 = query[2]-1;
		int y2 = query[3]-1;
		int tmp = numbers[x1][y2];
		int min =tmp;
		for (int i = y2; i > y1; i--) {
			numbers[x1][i] = numbers[x1][i-1];
			min = Math.min(numbers[x1][i-1],min);
		}
		for (int i = x1; i < x2; i++) {
			numbers[i][y1] = numbers[i+1][y1];
			min = Math.min(numbers[i+1][y1],min);
		}

		for (int i = y1; i < y2; i++) {
			numbers[x2][i] = numbers[x2][i+1];
			min = Math.min(numbers[x2][i+1],min);
		}
		for (int i = x2; i > x1+1; i--) {
			numbers[i][y2] = numbers[i-1][y2];
			min = Math.min(numbers[i-1][y2],min);
		}
		numbers[x1+1][y2]=tmp;
		return min;
	}

	public static void main(String[] args) {
		Main3 main3 = new Main3();
		main3.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});

	}
}
