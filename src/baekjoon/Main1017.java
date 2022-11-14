package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1017 {
	private static final int MAX_NUM = 2000;
	static ArrayList<Integer>[] edge;
	static ArrayList<Integer> left, right;
	static int[] matched;
	static boolean[] v;

	static HashSet<Integer> findPn() {
		boolean[] pnChk = new boolean[MAX_NUM + 1];
		for (int base = 3; base <= Math.sqrt(MAX_NUM); base += 2) {
			if (pnChk[base])
				continue;
			int tmp = base + base;
			while (tmp <= MAX_NUM) {
				pnChk[tmp] = true;
				tmp += base;
			}
		}

		HashSet<Integer> pn = new HashSet<>();
		for (int i = 3; i <= MAX_NUM; i += 2) {
			if (!pnChk[i])
				pn.add(i);
		}
		return pn;
	}

	static void findEdge() {
		edge = new ArrayList[left.size()];
		for (int i = 0; i < edge.length; i++)
			edge[i] = new ArrayList<>();

		HashSet<Integer> pn = findPn();

		for (int i = 0; i < left.size(); i++) {
			int from = left.get(i);

			for (int j = 0; j < right.size(); j++) {
				int to = right.get(j);
				if (pn.contains(from + to))
					edge[i].add(j);
			}
		}
	}

	static boolean matching(int from) {
		for (int i = 0; i < edge[from].size(); i++) {
			int to = edge[from].get(i);
			if (v[to])
				continue;
			v[to] = true;

			if (matched[to] == -1 || matching(matched[to])) {
				matched[to] = from;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int first = -1;

		ArrayList<Integer> even = new ArrayList<>();
		ArrayList<Integer> odd = new ArrayList<>();
		while (n-- > 0) {
			int cur = Integer.parseInt(st.nextToken());
			if ((cur & 1) == 1)
				odd.add(cur);
			else
				even.add(cur);
			if (first == -1)
				first = cur;
		}

		if (even.size() != odd.size()) {
			System.out.println(-1);
			return;
		}

		left = (first & 1) == 1 ? odd : even;
		right = (first & 1) == 1 ? even : odd;

		findEdge();

		for (ArrayList<Integer> integers : edge) {
			if (integers.size() == 0) {
				System.out.println(-1);
				return;
			}
		}

		matched = new int[right.size()];
		Arrays.fill(matched, -1);
		v = new boolean[right.size()];
		for (int i = 1; i < left.size(); i++) {
			if (!matching(i)) {
				System.out.println(-1);
				return;
			}

			v = new boolean[right.size()];
		}

		ArrayList<Integer> answer = new ArrayList<>(edge[0].size());

		for (int i = 0; i < edge[0].size(); i++) {
			int to = edge[0].get(i);

			if (matched[to] == -1 || matching(matched[to])) {
				matched[to] = -1;
				answer.add(right.get(to));
			}

			v = new boolean[right.size()];
		}

		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		for (Integer integer : answer)
			sb.append(integer).append(' ');

		System.out.println(answer.size() == 0 ? -1 : sb);
	}
}
