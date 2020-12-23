import java.util.Iterator;

public class EdgeAddInBipartite {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(5);
		graph.add(0, 1);
		graph.add(1, 2);
		graph.add(1, 3);
		graph.add(2, 4);

		counttheEdges(graph);

	}

	private static void counttheEdges(UnDirectedGraph graph) {
		int[] color = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			color[i] = -1;
		}
		for (int i = 0; i < graph.V; i++) {
			if (color[i] == -1) {
				DFS(graph, i, color);

			}
		}
		for (int i = 0; i < graph.V; i++) {
			System.out.println(color[i] + " ");
		}

	}

	private static void DFS(UnDirectedGraph graph, int i, int[] color) {
		if (color[i] == -1)
			color[i] = 0;

		Iterator<Integer> itr = graph.adjList[i].iterator();

		while (itr.hasNext()) {
			int j = itr.next();
			if (color[j] == -1) {
				color[j] = 1 - color[i];
				DFS(graph, j, color);

			}

		}

	}
}
