import java.util.Iterator;
import java.util.Stack;

public class LongestPathInADirectedAcyclicGraph {
	public static void main(String[] args) {
		DirectedWeightedGraph graph = new DirectedWeightedGraph(6);

		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 4, 4);
		graph.addEdge(2, 5, 2);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 5, 1);
		graph.addEdge(4, 5, -2);
		graph.addEdge(3, 4, -1);
		int s = 1;

		System.out.println("Following are the longest distances from source " + s);

		longestPath(graph, s);

	}

	private static void longestPath(DirectedWeightedGraph graph, int s) {
		boolean[] visited = new boolean[graph.V];

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < graph.V; i++) {

			if (visited[i] == false) {
				topoUtil(graph, visited, stack, i);

			}
		}
		int[] dist = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			dist[i] = Integer.MIN_VALUE;

		}

		dist[s] = 0;

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

		while (!stack.isEmpty()) {
			int u = stack.pop();
			System.out.println("u= " + u);

			if (dist[u] != Integer.MIN_VALUE) {
				Iterator<Node> itr = graph.adjList[u].iterator();
				while (itr.hasNext()) {
					Node node = itr.next();
					int v = node.v;
					int w = node.w;

					if (dist[u] + w > dist[v]) {
						dist[v] = dist[u] + w;

					}

				}
			}

		}
		for (int i = 0; i < graph.V; i++) {
			System.out.println("For vertex " + i + " maximum distance will be " + dist[i]);
		}

	}

	private static void topoUtil(DirectedWeightedGraph graph, boolean[] visited, Stack<Integer> stack, int i) {
		visited[i] = true;

		Iterator<Node> itr = graph.adjList[i].iterator();

		while (itr.hasNext()) {
			int v = itr.next().v;

			if (visited[v] == false) {
				System.out.println("v= " + v);
				topoUtil(graph, visited, stack, v);

			}

		}
		stack.add(i);

	}
}
