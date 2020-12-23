import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfEdges {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(9);

		graph.add(0, 1);
		graph.add(0, 7);
		graph.add(1, 7);
		graph.add(1, 2);
		graph.add(2, 3);
		graph.add(2, 5);
		graph.add(2, 8);
		graph.add(3, 4);
		graph.add(3, 5);
		graph.add(4, 5);
		graph.add(5, 6);
		graph.add(6, 7);
		graph.add(7, 8);

		printMinEdges(graph, 2, 3);

	}

	private static void printMinEdges(UnDirectedGraph graph, int src, int dest) {
		int[] weight = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		boolean[] visited = new boolean[graph.V];

		Queue<Integer> queue = new LinkedList<Integer>();

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
		System.out.println("visited will be " + weight[dest]);

	}
}
