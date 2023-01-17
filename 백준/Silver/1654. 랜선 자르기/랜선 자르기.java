import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int k = s.nextInt();
		int n = s.nextInt();
		int[] line = new int[k];
		long right = 0;
		for (int i = 0; i < k; i++) {
			line[i] = s.nextInt();
			if(right < line[i]) {
				right = line[i];
			}
		}
		right++;

		long left = 0; // 탐색 길이 최솟값
		long mid = 0;

		while (left < right) {

			// 범위 내에서 중간 길이를 구한다.
			mid = (right + left) / 2;


			long count = 0;

			// 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지를 구한다.

			for (int i = 0; i < k; i++) {
				count += (line[i] / mid);
			}

			/*
			 *  [upper bound 형식]
			 *
			 *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
			 *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
			 *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
			 */
			if(count < n) {
				right = mid;
			}
			else {
				left = mid + 1;
			}


		}

		// UpperBound로 얻어진 값(min)에 -1이 최대 길이가 된다.
		System.out.println(left - 1);
	}
}
