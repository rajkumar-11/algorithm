import java.util.Arrays;
import java.util.Iterator;

public class transitiveClosureOfGraph {
	public static int V = 4;

	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		System.out.println("Transitive closure of graph is :");

		transitiveClosure(graph);

	}

	private static void transitiveClosure(DirectedGraph graph) {
		int[][] tc = new int[V][V];


		for (int i = 0; i < V; i++) {
			DFS(i, i, tc, graph);

		}
		for (int i = 0; i < V; i++) {
			System.out.println(Arrays.toString(tc[i]));
		}

	}

	private static void DFS(int src, int dest, int[][] tc, DirectedGraph graph) {
		tc[src][dest] = 1;
//		System.out.println("src= "+src);

		Iterator<Integer> itr = graph.adjList[dest].iterator();

		while (itr.hasNext()) {
			int j = itr.next();
			if (tc[src][j] == 0) {
				DFS(src, j, tc, graph);
			}

		}
		
	
		
		

	}
}
