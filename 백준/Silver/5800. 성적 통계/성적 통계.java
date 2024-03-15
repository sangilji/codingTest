import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			int n = sc.nextInt();
			Integer nums[] = new Integer[n];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int gap = Integer.MIN_VALUE;

			sb.append("Class " + (i + 1)).append("\n");

			for (int j = 0; j < nums.length; j++) {
				nums[j] = sc.nextInt();

				if (max < nums[j]) {
					max = nums[j];
				}

				if (min > nums[j]) {
					min = nums[j];
				}
			}

			Arrays.sort(nums, Collections.reverseOrder());

			for (int j = 0; j < nums.length - 1; j++) {
				gap = Math.max(nums[j] - nums[j + 1], gap);
			}

			sb.append("Max " + max + ", Min " + min + ", Largest gap " + gap).append("\n");
		}

		System.out.println(sb.toString());
	}
}