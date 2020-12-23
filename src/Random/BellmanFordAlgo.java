
public class BellmanFordAlgo {
	public static void main(String[] args) {
		int V = 5, E = 8;

		DirectedGraphWithEdges graph = new DirectedGraphWithEdges(V, E);

		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		BellmanFord(graph);

	}

	private static void BellmanFord(DirectedGraphWithEdges graph) {
		int dist[] = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[0] = 0;

		for (int i = 1; i < graph.V; i++) {
			for (int j = 0; j < graph.E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int w = graph.edge[j].weight;

				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
				}

			}

		}
		for (int j = 0; j < graph.E; j++) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int w = graph.edge[j].weight;

			if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
				System.out.println("The graph contains negative weight cycle");
			}

		}

		for (int i = 0; i < graph.V; i++) {
			System.out.println("minimum distance at verted " + i + " is " + dist[i]);
		}

	}
}
