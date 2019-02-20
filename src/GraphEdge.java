import java.util.LinkedList;

public class GraphEdge {
	int V, E;
	Edge2 edge[];

	public GraphEdge(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge2[e];
		for (int i = 0; i < e; i++) {
			edge[i] = new Edge2();
		}

	}

	public GraphEdge(int V) 
	{
		LinkedList<Edge>list= new LinkedList<Edge>();
		
	}

	public int isCycle(GraphEdge graph) {
		int[] parent = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < graph.E; i++) {
			int x = graph.find(parent, graph.edge[i].src);
			int y = graph.find(parent, graph.edge[i].dest);

			if (x == y)
			{	
				System.out.println("yeah");
				
				return 1;
			
			}
			graph.union(parent, x, y);

		}

		return 0;
	}

	private void union(int[] parent, int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);

		parent[xset] = yset;
	}

	private int find(int[] parent, int i) {
		if (parent[i] == -1)
			return i;
		else
			return find(parent, parent[i]);

	}

	public int isCycleNlogN(GraphEdge graph) {
		subset[] set = new subset[graph.V];

		for (int i = 0; i < graph.V; i++)
		{
			set[i]=new subset(0,i);
		}

		for (int i = 0; i < graph.E; i++) {
			int x = findNlogN(graph.edge[i].src, set);
			int y = findNlogN(graph.edge[i].dest, set);
			if (x == y)
				{
				  System.out.println("Yes"+"i= "+i); 
				  return 1;
				}
			else
				UnionNlogN(set, x, y);

		}

		return 0;
	}

	private void UnionNlogN(subset[] set, int x, int y) {
		int xroot = findNlogN(x, set);
		int yroot = findNlogN(y, set);

		if (set[xroot].rank < set[yroot].rank) {
			set[xroot].parent = yroot;
		} else if (set[xroot].rank > set[yroot].rank) {
			set[yroot].parent = xroot;
		} else {
			set[yroot].parent = xroot;
			set[xroot].rank++;
		}

	}

	private int findNlogN(int i, subset[] set)
	{
		if (set[i].parent != i)
			set[i].parent = findNlogN(set[i].parent, set);

		return set[i].parent;
	}

}





	
