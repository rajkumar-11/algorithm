import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CountNodesWithinKDistanceFromAllNodes {

	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(10);
		graph.add(1, 0);
		graph.add(0, 3);
		graph.add(0, 8);
		graph.add(2, 3);
		graph.add(3, 5);
		graph.add(3, 6);
		graph.add(3, 7);
		graph.add(4, 5);
		graph.add(5, 9);

		int marked[] = { 1, 2, 4 };

		int k = 3;

		nodesKDistanceFromMarked(graph, k, marked);

	}

	private static void nodesKDistanceFromMarked(UnDirectedGraph graph, int k, int[] marked) {
		int size = marked.length;

		int[][] weights = new int[size][graph.V];

		for (int i = 0; i < weights.length; i++) {

			int src = marked[i];
			minEdges(graph, src, weights[i]);

		}
		int count = 0;

		boolean[] markedless = new boolean[graph.V];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < graph.V; j++) {

				if (weights[i][j] <= k)
					continue;
				else {
					markedless[j] = true;
				}

			}

		}

		for (int i = 0; i < graph.V; i++) {
			System.out.print(markedless[i] + " ");
		}

		System.out.println(count);

	}

	private static void minEdges(UnDirectedGraph graph, int src, int[] weight) {
		boolean[] visited = new boolean[graph.V];

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < graph.V; i++) {
			weight[i] = Integer.MAX_VALUE;
		}

		queue.add(src);

		weight[src] = 0;

		while (!queue.isEmpty()) {
			int j = queue.poll();
			visited[j] = true;

			Iterator<Integer> itr = graph.adjList[j].iterator();

			while (itr.hasNext()) {
				int k = itr.next();

				if (weight[j] + 1 < weight[k]) {
					weight[k] = weight[j] + 1;

				}
				if (visited[k] == false) {
					queue.add(k);
				}

			}

		}

	}
}
