import java.util.Iterator;

public class BiconnectedGraph {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(3);
		graph.add(1, 0);
		graph.add(1, 2);
		graph.add(2, 0);
//		graph.add(0, 3);
//		graph.add(3, 4);
//		graph.add(2, 4);
		// graph.add(4, 5);
		//

		if (isGraphBiConnected(graph))
			System.out.println("The graph is biconnected");
		else
			System.out.println("No the graph is not biconnected");

	}

	private static boolean isGraphBiConnected(UnDirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];

		int[] dist = new int[graph.V];
		int[] low = new int[graph.V];
		int[] parent = new int[graph.V];

		for (int i = 0; i < graph.V; i++)
			parent[i] = -1;
		//
		// dist[0] = 1;
		// low[0] = 1;

		if (DFSarticulation(0, graph, visited, dist, low, parent, 0))
			return false;

		for (int i = 0; i < graph.V; i++) {

			if (visited[i] == false) {
				System.out.println("visited" + " i= " + i);
				return false;

			}
		}

		return true;
	}

	private static boolean DFSarticulation(int u, UnDirectedGraph graph, boolean[] visited, int[] dist, int[] low,
			int[] parent, int time) {
		visited[u] = true;
		int child = 0;
		low[u] = dist[u] = ++time;

		Iterator<Integer> itr = graph.adjList[u].iterator();

		while (itr.hasNext()) {
			int v = itr.next();
			child++;
			// System.out.println("u= " + u + " v= " + v);
			if (visited[v] == false) {

				
				parent[v] = u;
				// System.out.println("here");

				if (DFSarticulation(v, graph, visited, dist, low, parent, time))
					return true;

				low[u] = Math.min(low[v], low[u]);

				if (parent[u] != -1 && dist[u] <= low[v]) {
					System.out.println("low" + " u = " + u + " v= " + v);
					return true;
				}

				if (parent[u] == -1 && child >= 2)
				{
					System.out.println("root");
					return true;
				}

			} else if (v != parent[u]) {
				System.out.println("u= " + u + " v= " + v + " dist[v]= " + dist[v] + " low[v]= " + low[v]);
				low[u] = Math.min(dist[v], low[u]);
			}

		}

		return false;

	}

}
