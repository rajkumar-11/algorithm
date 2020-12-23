import java.util.Iterator;

public class DijkstraAlgoAdjacencyList {
	static int V = 9;

	public static void main(String[] args) {
		UnDirectedWeightedGraph graph = new UnDirectedWeightedGraph(9);
		graph.add(0, 1, 4);
		graph.add(0, 7, 8);
		graph.add(1, 2, 8);
		graph.add(1, 7, 11);
		graph.add(2, 8, 2);
		graph.add(2, 3, 7);
		graph.add(2, 5, 4);
		graph.add(3, 4, 9);
		graph.add(3, 5, 14);
		graph.add(4, 5, 10);
		graph.add(5, 6, 2);
		graph.add(6, 7, 1);
		graph.add(6, 8, 6);
		graph.add(7, 8, 7);

		dijkstra(graph);

	}

	private static void dijkstra(UnDirectedWeightedGraph graph) {
		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;

		for (int i = 0; i < V - 1; i++) {
			int u = min(sptSet, dist);
//			System.out.println("u= " + u);
			sptSet[u] = true;

			Iterator<Node> itr = graph.adjList[u].iterator();

			while (itr.hasNext()) {
				Node node = itr.next();

				int v = node.v;
				int w = node.w;

				if (sptSet[v] == false && dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v])) {
					dist[v] = dist[u] + w;

				}

			}

		}

		for (int i = 0; i < V; i++) {
			System.out.println("min distance for index " + i + " is =" + dist[i]);
		}

	}

	private static int min(boolean[] sptSet, int[] dist) {
		int min_index = -1, min_value = Integer.MAX_VALUE;

		for (int i = 0; i < V; i++) {
			if (sptSet[i] == false && dist[i] < min_value) {
				min_index = i;
				min_value = dist[i];

			}

		}

		return min_index;
	}
}
