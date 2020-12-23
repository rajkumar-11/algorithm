import java.awt.Color;
import java.util.LinkedList;

public class DirectedGraph {

	LinkedList[] adjList = null;
	int V;

	public DirectedGraph(int v) {
		this.V = v;
		adjList = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<>();

		}

	}

	public void addEdge(int i, int j) {
		adjList[i].add(j);

	}



}
