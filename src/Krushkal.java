import java.time.chrono.IsoChronology;
import java.util.Arrays;
import java.util.Collections;

public class Krushkal {
	public static void main(String[] args) {
		int v = 4, E = 5;

		WeightedGraph graph = new WeightedGraph(v, E);

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

		MST(graph);

	}

	private static void MST(WeightedGraph graph)
	{
		Arrays.sort(graph.edge, new EdgeSort());

		WeightedGraph mstGraph = new WeightedGraph(graph.V, graph.V - 1);

		int j = 0;

		subset2[] set = new subset2[graph.V];

		for (int i = 0; i < graph.V; i++) {
			set[i] = new subset2();

			set[i].parent = i;
			set[i].rank = 0;

		}

		int l = 0;
		while (l < graph.V - 1) {
			Edge edge = graph.edge[j];
//			System.out.println("l= " + l + " j= " + j);

			// mstGraph.edge[l] = edge;

			int x = find(set, edge.src);
			int y = find(set, edge.dest);
//			System.out.println("x= " + x + " y =" + y);

			if (x != y) {
				
				
				mstGraph.edge[l] = edge;
				l++;
				union(set, x, y);

			}

			j++;

		}
		for (int i = 0; i < l; i++) {
			System.out.println(mstGraph.edge[i].src + "  to  " + mstGraph.edge[i].dest + "  with weight= " + mstGraph.edge[i].weight);

		}
		

	}

	private static void union(subset2[] subsets, int xroot, int yroot) {
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
