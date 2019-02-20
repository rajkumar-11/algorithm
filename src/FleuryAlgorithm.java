import java.util.Iterator;

public class FleuryAlgorithm {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(4);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 2);
		graph.add(2, 3);

		printEulerTour(graph);

		System.out.println();

		UnDirectedGraph graph2 = new UnDirectedGraph(3);
		graph2.add(0, 1);
		graph2.add(1, 2);
		graph2.add(2, 0);
		printEulerTour(graph2);

		System.out.println();

		UnDirectedGraph graph3 = new UnDirectedGraph(5);
		graph3.add(1, 0);
		graph3.add(0, 2);
		graph3.add(2, 1);
		graph3.add(0, 3);
		graph3.add(3, 4);
		graph3.add(3, 2);
		graph3.add(3, 1);
		graph3.add(2, 4);

		printEulerTour(graph3);

	}

	private static void printEulerTour(UnDirectedGraph graph) {
		int u = 0;
		for (int i = 0; i < graph.V; i++) {
			if (graph.adjList[i].size() % 2 == 1) {
				u = i;
				break;

			}

		}

		printEulerUtils(graph, u);

	}

	private static void printEulerUtils(UnDirectedGraph graph, int u) {
		// Iterator<Integer> itr = graph.adjList[u].iterator();

		// if()

		for (int i = 0; i < graph.adjList[u].size(); i++) {
			int v = (int) graph.adjList[u].get(i);

			// System.out.println("here"+" u= "+u);

			if (isValid(graph, u, v)) {
				System.out.print(u + "  => " + v + " ");
				removeEdge(graph, u, v);
				printEulerUtils(graph, v);
			}

		}

	}

	private static boolean isValid(UnDirectedGraph graph, int u, int v) {
		if (graph.adjList[u].size() == 1)
			return true;

		boolean[] visited = new boolean[graph.V];

		int count1 = DFSCount(graph, u, visited);

		removeEdge(graph, u, v);

		// System.console()
		visited = new boolean[graph.V];

		int count2 = DFSCount(graph, u, visited);

		addEdge(graph, u, v);

		// System.out.println("count1= "+count1+" count2= "+count2+" u="+u+" v=
		// "+v);

		return (count1 > count2) ? false : true;
	}

	private static void addEdge(UnDirectedGraph graph, int u, int v) {
		graph.adjList[u].add(v);
		graph.adjList[v].add(u);
	}

	private static void removeEdge(UnDirectedGraph graph, int u, int v) {
		// System.out.println("u= " + u + " v= " + v);
		graph.adjList[u].remove(new Integer(v));
		graph.adjList[v].remove(new Integer(u));

	}

	private static int DFSCount(UnDirectedGraph graph, int u, boolean[] visited) {
		visited[u] = true;

		int count = 1;

		Iterator<Integer> itr = graph.adjList[u].iterator();

		while (itr.hasNext()) {
			int v = itr.next();

			if (visited[v] == false) {
				count += DFSCount(graph, v, visited);

			}

		}

		return count;
	}
}
