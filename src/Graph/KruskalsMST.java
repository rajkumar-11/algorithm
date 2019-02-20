package Graph;

import java.util.Arrays;

public class KruskalsMST {
	public static void main(String[] args) {
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		EdgeGraph graph = new EdgeGraph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;

		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;

		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;

		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;

		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;

		KruskalMST(graph);

	}

	private static void KruskalMST(EdgeGraph graph) {
		subset[] set = new subset[graph.V];
		for (int i = 0; i < graph.V; i++) {
			set[i] = new subset();

		}

		Edge[] result = new Edge[graph.V];

		for (int i = 0; i < graph.V; i++) {
			set[i].parent = -1;
			set[i].rank = 0;

		}

		Edge[] edges = graph.edge;

		Arrays.sort(edges);
		int i = 0;
		int e = 0;

		while (e < graph.V - 1) {
			Edge edge = new Edge();
			System.out.println("i= " + i);
			edge = edges[i++];

			int x = find(set, edge.src);
			int y = find(set, edge.dest);

			if (x != y) {

				result[e++] = edge;
				union(set, edge.src, edge.dest);

			}

		}
		System.out.println("Following are the edges in the constructed tree ");

		for (i = 0; i < e; i++) {
			System.out.println(result[i].src + " " + result[i].dest + " " + result[i].weight);

		}

	}

	private static void union(subset[] set, int src, int dest) {
		if (set[src].rank > set[dest].rank) {
			set[dest].parent = src;

		} else if (set[src].rank < set[dest].rank) {
			set[src].parent = dest;
		} else {
			set[src].parent = dest;
			set[src].rank++;

		}

	}

	private static int find(subset[] set, int i) {
		if (set[i].parent != -1)
			return find(set, set[i].parent);

		return i;
	}

}
