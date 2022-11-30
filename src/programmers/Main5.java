package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main5 {
	public int solution(int n) {
		Set<String> set = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		set.add("()");
		for (int dp = 1; dp < n; dp++) {
			for (String s : set) {
				List<String> tmp = new ArrayList<>(Arrays.asList(s.split("")));
				for (int i = 0; i < s.length(); i++) {
					tmp.add(i, "(");
					for (int j = i + 1; j < s.length() + 1; j++) {
						tmp.add(j, ")");
						System.out.println(String.join("", tmp));
						set2.add(String.join("", tmp));
						tmp.remove(j);
					}
					tmp.remove(i);
				}
			}
			set.clear();
			set.addAll(set2);
			set2.clear();
		}
		for (String s : set) {
			System.out.println(s);
		}
		return set.size();
	}

	public static void main(String[] args) {
		Main5 m = new Main5();
		System.out.println(m.solution(3));
	}
}
