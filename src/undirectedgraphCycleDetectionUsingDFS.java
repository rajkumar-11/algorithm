import java.util.Arrays;
import java.util.Iterator;

public class undirectedgraphCycleDetectionUsingDFS {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(5);
		graph.add(1, 0);
		graph.add(1, 3);
		graph.add(3, 4);
		graph.add(4, 2);
//		graph.add(2, 0);
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

		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false) {

				if (isCyclicUtil(graph, visited, parent, i))
					return true;

			}

		}

		return false;
	}

	private static boolean isCyclicUtil(UnDirectedGraph graph, boolean[] visited, int[] parent, int u) {
		visited[u] = true;

		Iterator<Integer> itr = graph.adjList[u].iterator();

		System.out.println("parent");

		for (int i = 0; i < parent.length; i++) {
			System.out.print(parent[i] + " ");

		}
		System.out.println();

		while (itr.hasNext()) {
			int v = itr.next();
			// parent
			System.out.println("u1= " + u + " v1= " + v);

			if (visited[v] == false) {
				parent[v] = u;
				if (isCyclicUtil(graph, visited, parent, v)) {
					return true;

				}
			} else if (visited[v] == true && parent[u] != v ) {

				System.out.println("u= " + u + " v= " + v + " parent[v]= " + parent[v]);

				return true;

			}

		}

		return false;
	}

}
