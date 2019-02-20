
public class UnionFindByRankAndPathCompression {
	public static void main(String[] args) {

		GraphEdge graph = new GraphEdge(6, 5);

		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		graph.edge[2].src = 2;
		graph.edge[2].dest = 3;

		graph.edge[3].src = 3;
		graph.edge[3].dest = 4;

		graph.edge[4].src = 4;
		graph.edge[4].dest = 5;

		// graph.edge[2].src = 5;
		// graph.edge[2].dest = 2;

		if (isCycle(graph))
			System.out.println("yes the graph contains cycle");
		else
			System.out.println("No the graph does not contain cycle");

	}

	private static boolean isCycle(GraphEdge graph) {
		NodeInfo nodeInfo = new NodeInfo(graph.V);

		for (int i = 0; i < graph.V; i++) {
			nodeInfo.parent[i] = i;
			nodeInfo.rank[i] = i;
		}
		for (int i = 0; i < graph.E; i++) {
			int x = find(nodeInfo, graph.edge[i].src);
			int y = find(nodeInfo, graph.edge[i].dest);

			if (x == y) {
				System.out
						.println("x= " + x + "y= " + y + " src= " + graph.edge[i].src + " dest= " + graph.edge[i].dest);
				return true;
			}

			union(nodeInfo, x, y);

		}

		return false;
	}

	private static void union(NodeInfo nodeInfo, int x, int y) {
		// int xroot = find(nodeInfo, x);
		// int yroot = find(nodeInfo, y);

		if (nodeInfo.rank[x] > nodeInfo.rank[y]) {
			nodeInfo.parent[y] = x;
		} else if (nodeInfo.rank[x] < nodeInfo.rank[y]) {
			nodeInfo.parent[x] = y;
		} else {
			nodeInfo.parent[x] = y;
			nodeInfo.rank[y]++;

		}

	}

	private static int find(NodeInfo nodeInfo, int i) {
		if (nodeInfo.parent[i] == i)
			return i;

		return find(nodeInfo, nodeInfo.parent[i]);
	}

}
