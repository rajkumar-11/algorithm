
public class FloydWarshallAlgorithm {
	final static int V = 4;

	public static void main(String[] args) {
		int graph[][] = { { 0, 5, Integer.MAX_VALUE, 10 }, { Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };

		floydMarshalAlgo(graph);

	}

	private static void floydMarshalAlgo(int[][] graph) {
		int[][] dist = new int[V][V];

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {

				dist[i][j] = graph[i][j];

			}

		}

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {

				for (int j = 0; j < V; j++) {
					if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
							&& dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}

				}

			}

		}
		printGraph(dist);

	}

	private static void printGraph(int[][] dist) {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(dist[i][j]+" ");

			}
			System.out.println();
		}

	}

}
