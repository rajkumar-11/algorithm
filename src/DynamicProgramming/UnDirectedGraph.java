package DynamicProgramming;
import java.util.LinkedList;

public class UnDirectedGraph {

	static LinkedList[] adjList = null;
	static int V;

	public UnDirectedGraph(int v) {
		this.V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {	
			adjList[i] = new LinkedList<Integer>();

		}

	}

	@SuppressWarnings("unchecked")
	void add(int i, int j) {
		adjList[i].add(j);
		adjList[j].add(i);

	}

}
