import java.util.Arrays;
import java.util.Comparator;

public class WeightedGraph {
	int V, E;
	Edge[] edge;

	public WeightedGraph(int v, int e) {
		this.V = v;
		this.E = e;
		this.edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}

	}

	public void BellmanFord(WeightedGraph graph, int src) {
		int V = graph.V;
		int E = graph.E;
		int[] dist = new int[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;

				if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight) {
					dist[v] = dist[u] + weight;
				}

			}
		}

		for (int j = 0; j < E; j++) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;

			if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight) {
				System.out.println("Graph contains negative Weight Cycle");
			}

		}
		printArr(dist, V);

	}

	private void printArr(int[] dist, int v2) {

		System.out.println("Vertex distance from Source ");
		for (int i = 0; i < V; i++) {
			System.out.println(i + "\t\t" + dist[i]);
		}

	}

	public void kruskalMST() {
		Edge result[] = new Edge[V];

		Arrays.sort(edge);

		subset subsets[] = new subset[V];

		for (int j = 0; j < V; j++) {
			subsets[j] = new subset(0, j);

		}
		int j = 0;
		int i=0;
		System.out.println("V= "+V);
		for (; j < V-1;) 
		{
			 Edge next_edge = new Edge();
			 System.out.println("i= "+i);
	         next_edge = edge[i];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			if (x != y)
			{
				System.out.println("j= "+j);
				
				result[j++] = next_edge;
				union(subsets, x, y);

			}
          i++;
		}
		System.out.println("following are the edges in MST");

		for (int z = 0; z < j; z++) 
		{
			System.out.println(result[z].src + "---" + result[z].dest + "  ==>   " + result[z].weight);

		}

	}

	private void union(subset[] subsets, int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		else {
			subsets[xroot].parent = yroot;
			subsets[yroot].rank++;
		}

	}

	private int find(subset[] subsets, int i) {
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

	public void addedge(int i,int src, int dest, int w) 
	{
      this.edge[i].src=src;
      this.edge[i].dest=dest;
      this.edge[i].weight=w;
		
	}

}

