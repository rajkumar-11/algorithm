import java.util.Iterator;

public class EulerCircuitInADirectedGraph {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 0);
		if (isEulerianCycle(graph)) {
			System.out.println("Given directed graph is Eulerian");

		} else {
			System.out.println("Given graph is not Eulerian");
		}

	}

	private static boolean isEulerianCycle(DirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];
		InOut[] inout = new InOut[graph.V];

		DFS(0, graph, visited);

		return false;
	}

	private static void DFS(int i, DirectedGraph graph, boolean[] visited) {
		visited[i] = true;

		Iterator<Integer> itr = graph.adjList[i].iterator();

		while (itr.hasNext()) {

			int v = itr.next();

		}

	}
}

class InOut {
	int in, out;

	public InOut(int in, int out) {
		this.in = in;
		this.out = out;

	}

}