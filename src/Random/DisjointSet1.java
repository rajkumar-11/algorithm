import java.lang.reflect.Array;
import java.util.Arrays;

public class DisjointSet1 {
	public static void main(String[] args) {
		graphUnionFind graph = new graphUnionFind(4, 3);

		graph.edges[0].src = 0;
		graph.edges[0].dest = 1;

		graph.edges[1].src = 0;
		graph.edges[1].dest = 2;

		graph.edges[2].src = 3;
		graph.edges[2].dest = 2;

//		graph.edges[3].src = 3;
//		graph.edges[3].dest = 4;

//		graph.edges[4].src = 2;
//		graph.edges[4].dest = 4;

		if (isCyclic(graph)) {
			System.out.println("Yes the undirected graph is cyclic");
		} else {
			System.out.println("The undirected graph is not cyclic");
		}

	}

	private static boolean isCyclic(graphUnionFind graph) {
		int[] parent = new int[graph.V];

		Arrays.fill(parent, -1);

		for (int i = 0; i < graph.E; i++) {
			int x = find(parent, graph.edges[i].src);
			int y = find(parent, graph.edges[i].dest);

			if (x == y)
				return true;

			union(parent, x, y);

		}

		return false;
	}

	private static void union(int[] parent, int x, int y) {
		parent[x] = y;

	}

	private static int find(int[] parent, int src) {
		if (parent[src] == -1)
			return src;

		return find(parent, parent[src]);
	}

}
