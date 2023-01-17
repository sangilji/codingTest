
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node {
		int last;
		int cost;

		public Node(int last, int cost) {
			this.last = last;
			this.cost = cost;
		}
	}

	static int[] max;
	static int K;
	static List<List<Node>> nodes = new ArrayList<>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int V = s.nextInt();
		int E = s.nextInt();
		K = s.nextInt();
		max = new int[V + 1];
		Arrays.fill(max, Integer.MAX_VALUE);
		max[K] = 0;
		for (int i = 0; i < V + 1; i++) {
			nodes.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			int w = s.nextInt();
			nodes.get(u).add(new Node(v, w));
		}

		bfs();
		for (int i = 1; i < max.length; i++) {
			if (max[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(max[i]);

		}

	}

	public static void bfs() {
		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		q.add(new Node(K, 0));

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (max[tmp.last] < tmp.cost) {
				continue;
			}
			for (int i = 0; i < nodes.get(tmp.last).size(); i++) {
				Node currentNode = nodes.get(tmp.last).get(i);
				if(max[currentNode.last] > currentNode.cost + tmp.cost){
					max[currentNode.last] = currentNode.cost + tmp.cost;
					q.add(new Node(currentNode.last, max[currentNode.last]));
				}

			}
		}
	}
}

