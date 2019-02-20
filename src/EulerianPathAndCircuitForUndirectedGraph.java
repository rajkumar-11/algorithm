import java.util.Iterator;

public class EulerianPathAndCircuitForUndirectedGraph {

	static int count = 0;

	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(3);
		// graph.add(1, 0);
		// graph.add(1, 2);
		// graph.add(2, 0);
		// graph.add(0, 3);
		// graph.add(3, 4);
		// graph.add(4, 0);

		check(graph);

	}

	private static void check(UnDirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];

		for (int i = 0; i < graph.V; i++) {
			if (graph.adjList[i].size() != 0) {
				DFS(0, graph, visited);
				break;
			}
		}
		int oddCount = 0;

		int evenCont = 0;
		System.out.println("count= " + count);

		for (int i = 0; i < graph.V; i++) {
			if (graph.adjList[i].size() == 0) {
				continue;

			} else if (graph.adjList[i].size() % 2 == 0) {
				evenCont++;
				continue;
			} else if (graph.adjList[i].size() % 2 != 0) {
				// System.out.println("i= " + i);
				oddCount++;

			} else {

				System.out.println(" No Eulerian ");

			}

		}
		System.out.println("odd count= " + oddCount);
		if (evenCont == count)
			System.out.println("Eulerian Circle");
		else if (oddCount == 0 || oddCount == 2)
			System.out.println("Eulerian Path");

		else
			System.out.println("No Eulerian");
	}

	private static void DFS(int i, UnDirectedGraph graph, boolean[] visited) {
		count = count + 1;
		visited[i] = true;

		// System.out.println("count in "+ count);
		Iterator<Integer> itr = graph.adjList[i].iterator();

		while (itr.hasNext()) {
			int v = itr.next();
			if (visited[v] == false)
				DFS(v, graph, visited);

		}

	}
}
