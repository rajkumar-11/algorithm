import java.util.Iterator;

public class AP {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(6);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 3);
		graph.add(3, 4);
		graph.add(3, 5);
		graph.add(2, 3);
		graph.add(4, 5);

		ArticulationPoints(graph);

	}

	private static void ArticulationPoints(UnDirectedGraph graph) {
		int[] disc = new int[graph.V];
		int[] low = new int[graph.V];
		int[] parent = new int[graph.V];
		boolean[] AP = new boolean[graph.V];

		for (int i = 0; i < graph.V; i++) {
			disc[i] = -1;
			parent[i] = -1;
		}
		int time = 1;
		for (int i = 0; i < graph.V; i++) {
			if (disc[i] == -1) {
				ArticulationUtil(i, disc, low, graph, parent, AP, time);
			}

		}
		for (int i = 0; i < graph.V; i++) {
			System.out.print(AP[i] + " ");
		}

	}

	private static void ArticulationUtil(int u, int[] disc, int[] low, UnDirectedGraph graph, int[] parent,
			boolean[] AP, int time) {
		disc[u] = low[u] = time;
		time = time + 1;

		Iterator<Integer> itr = graph.adjList[u].iterator();

		int count = 0;

		while (itr.hasNext()) {
			int v = itr.next();

			count = count + 1;

			if (disc[v] == -1) {
				parent[v] = u;
				ArticulationUtil(v, disc, low, graph, parent, AP, time);
				low[u] = Math.min(low[u], low[v]);

				if (parent[u] == -1 && count >= 2) {
					System.out.println("first " + u);
					AP[u] = true;

				}
				if (parent[u] != -1 && low[v] >= disc[u]) {
					System.out.println("Second " + u);
					AP[u] = true;

				}
			} else if (v != parent[u]) {
				low[u] = Math.min(low[u], disc[v]);

			}

		}

	}
}
