import java.util.LinkedList;

public class UnDirectedWeightedGraph {
	static LinkedList[] adjList = null;
	static int V;

	public UnDirectedWeightedGraph(int v) {
		this.V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<Node>();

		}

	}

	@SuppressWarnings("unchecked")
	void add(int u, int v, int w) {
		adjList[u].add(new Node(v, w));
		adjList[v].add(new Node(u, w));

	}

}



