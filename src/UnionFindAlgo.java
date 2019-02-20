
public class UnionFindAlgo {
	public static void main(String[] args) {
		GraphEdge graph = new GraphEdge(4, 3);

		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		graph.edge[2].src = 2;
		graph.edge[2].dest = 3;

		if (isCycle(graph))
			System.out.println("yes the graph contains cycle");
		else
			System.out.println("No the graph does not contain cycle");

	}

	private static boolean isCycle(GraphEdge graph) {
		int[] parent = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < graph.E; i++) {
			int src = graph.edge[i].src;
			int dest = graph.edge[i].dest;

			int x = find(parent, src);
			int y = find(parent, dest);

			if (x == y) {
				return true;
			}
			union(parent, x, y);

		}

		return false;
	}

	private static void union(int[] parent, int x, int y) {
		parent[x] = y;

	}

	private static int find(int[] parent, int i) {
		if (parent[i] == -1)
			return i;
		else
			return find(parent, parent[i]);
	}
}
