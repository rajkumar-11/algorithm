
public class UnionFind2 {
	public static void main(String[] args) {
		graphUnionFind graph = new graphUnionFind(5, 5);

		graph.edges[0].src = 0;
		graph.edges[0].dest = 1;

		graph.edges[1].src = 0;
		graph.edges[1].dest = 2;

		graph.edges[2].src = 1;
		graph.edges[2].dest = 3;

		graph.edges[3].src = 3;
		graph.edges[3].dest = 4;

		graph.edges[4].src = 2;
		graph.edges[4].dest = 4;

		if (isCyclic(graph)) {
			System.out.println("Yes the undirected graph is cyclic");
		} else {
			System.out.println("The undirected graph is not cyclic");
		}

	}

	private static boolean isCyclic(graphUnionFind graph) {
		subset2[] set = new subset2[graph.V];

		for (int i = 0; i < graph.V; i++) {
			set[i] = new subset2();
			set[i].rank = 0;
			set[i].parent =i;

		}

		for (int i = 0; i < graph.E; i++) {
			int x = find(set, graph.edges[i].src);
			int y = find(set, graph.edges[i].dest);

			if (x == y)
				return true;

			union(set, x, y);

		}

		return false;
	}

	private static void union(subset2[] subsets, int xroot, int yroot) {

		// int xroot = find(subsets, x);
		// int yroot = find(subsets, y);

		// System.out.println("x= "+x+" y= "+y+" xroot = "+ xroot+" yroot=
		// "+yroot);

		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[yroot].rank < subsets[xroot].rank)
			subsets[yroot].parent = xroot;
		else {
			subsets[xroot].parent = yroot;
			subsets[yroot].rank++;
		}
	}

	private static int find(subset2[] set, int src) {
		if (set[src].parent != src)
			return find(set, set[src].parent);

		return set[src].parent;
	}

}

class subset2 {

	int parent, rank;

}
