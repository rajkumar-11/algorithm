import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class undirectedgraphCycleDetectionUsingBFS {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(3);
		graph.add(1, 0);
		graph.add(1, 2);
		// graph.add(3, 4);
		// graph.add(4, 2);
		// graph.add(2, 0);
		// graph.add(1, 0);
		// graph.add(1, 0);

		if (iscyclic(graph)) {
			System.out.println("Yes the  given graph is cyclic");

		} else {
			System.out.println("No the graph is not cyclic");
		}

	}

	private static boolean iscyclic(UnDirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];
		int[] parent = new int[graph.V];

		Arrays.fill(parent, -1);

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(0);

		while (!queue.isEmpty()) {
			int u = queue.poll();
			visited[u] = true;
			// System.out.println(queue.size());

			Iterator<Integer> itr = graph.adjList[u].iterator();

			while (itr.hasNext()) {
				int v = itr.next();

				if (visited[v] == false) {
					parent[v] = u;

					queue.add(v);

				} else if (visited[v] == true && parent[u] != v && parent[u] != -1) {
					return true;
				}

			}

		}

		return false;
	}
}
