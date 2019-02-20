import java.util.ArrayList;
import java.util.LinkedList;

public class UnDirectedGraph {

	static ArrayList[] adjList = null;
	static int V;

	public UnDirectedGraph(int v) {
		this.V = v;
		adjList = new ArrayList[v];
		for (int i = 0; i < v; i++) {	
			adjList[i] = new ArrayList<Integer>();

		}

	}

	@SuppressWarnings("unchecked")
	void add(int i, int j) {
		adjList[i].add(j);
		adjList[j].add(i);

	}

}
