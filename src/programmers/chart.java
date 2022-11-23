package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class chart {
	static class Solution {
		public String solution(int n, int k, String[] cmd) {
			StringBuilder answer = new StringBuilder();
			List<Integer> arr = new ArrayList<>();
			Stack<int[]> trash = new Stack<>();
			for (int i = 0; i < n; i++) {
				arr.add(i);
			}

			for (String s : cmd) {
				String[] tmp = s.split(" ");
				switch (tmp[0]) {
					case "D" -> k += Integer.parseInt(tmp[1]);
					case "U" -> k -= Integer.parseInt(tmp[1]);
					case "C" -> {
						trash.push(new int[] {arr.get(k), k});  // 4 추가
						arr.remove(k);
						if (arr.size() == k) {
							k--;
						}
					}
					default -> {
						int[] t = trash.pop();
						if (k >= t[1]) {
							k++;
						}
						arr.add(t[1], t[0]);
					}
				}
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				if (arr.get(count) == i) {
					answer.append("O");
					if (count < arr.size()-1) {
						count++;
					}
				} else {
					answer.append("X");
				}
			}

			return answer.toString();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(8, 2, new String[] {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
	}
}
