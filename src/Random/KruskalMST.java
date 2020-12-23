import java.util.Arrays;

public class KruskalMST {
	public static void main(String[] args) {
		int V = 4;
		int E = 5;
		WeightedGraph graph = new WeightedGraph(V, E);

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

		kruskalMST(graph);

	}

	private static void kruskalMST(WeightedGraph graph) {

		Edge[] result = new Edge[graph.V - 1];

		Arrays.sort(graph.edge);

		NodeInfo nodeInfo = new NodeInfo(graph.V);

		for (int i = 0; i < graph.V; i++) {
			nodeInfo.parent[i] = i;
			nodeInfo.rank[i] = i;
		}
		int e = 0;
		int i = 0;

		while (e < graph.V - 1) {
			Edge edge = graph.edge[i++];

			int x = find(nodeInfo, edge.src);
			int y = find(nodeInfo, edge.dest);

			System.out.println("x= " + x + " y= " + y);

			if (x != y) {
				result[e++] = edge;
				union(x, y, nodeInfo);

			}

		}

		for (i = 0; i < e; i++) {
			System.out.println(result[i].src + "  to  " + result[i].dest + "  with weight= " + result[i].weight);

		}

	}

	private static void union(int x, int y, NodeInfo nodeInfo) {
		if (nodeInfo.rank[x] < nodeInfo.rank[y]) {
			nodeInfo.parent[x] = y;
		} else if (nodeInfo.rank[x] < nodeInfo.rank[y]) {
			nodeInfo.parent[y] = x;
		} else {
			nodeInfo.parent[y] = x;
			nodeInfo.rank[x]++;

		}

	}

	private static int find(NodeInfo nodeInfo, int i) {

		if (nodeInfo.parent[i] == i)
			return i;
		else
			return (find(nodeInfo, (nodeInfo.parent[i])));
	}
}
