
public class DijkstraAlgoMatrix {
	static int V = 9;

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		dijkstra(graph);

	}

	private static void dijkstra(int[][] graph) {
		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;

		}

		dist[0] = 0;

		// int i=0;
		for (int i = 0; i < V - 1; i++) {
			int u = min(dist, sptSet);
			sptSet[u] = true;
			System.out.println("u= "+u);

			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && sptSet[v] == false && dist[u] != Integer.MAX_VALUE
						&& (dist[u] + graph[u][v] < dist[v])) {
					dist[v] = dist[u] + graph[u][v];

				}
			}

		}

		for (int i = 0; i < V; i++) {
			System.out.println("min distance for index " + i + " is =" + dist[i]);
		}

	}

	private static int min(int[] dist, boolean[] sptSet) {
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
