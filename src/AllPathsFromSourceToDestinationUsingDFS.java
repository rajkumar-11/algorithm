import java.util.Iterator;

public class AllPathsFromSourceToDestinationUsingDFS {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(4);
		graph.addEdge(0, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(0, 3);
		graph.addEdge(0, 1);

		printPaths(graph, 2, 3);
	}

	private static void printPaths(DirectedGraph graph, int src, int dest) {
		boolean visited[] = new boolean[graph.V];

		Iterator<Integer> itr = graph.adjList[src].iterator();
    
		String s = String.valueOf(src);

		visited[src]=true;
		
		while (itr.hasNext()) {
			int j = itr.next();
			if (visited[j] == false)
				DFS(graph, j, visited, dest, s);

		}

	}

	private static void DFS(DirectedGraph graph, int i, boolean[] visited, int dest, String s) {
		visited[i] = true;

		s += " ";
		s += String.valueOf(i);

		if (i == dest)
		{
			System.out.println("here");

			System.out.println(s);
			visited[i] = false;
			return;

		}
		Iterator<Integer> itr = graph.adjList[i].iterator();

		while (itr.hasNext()) {
			int j = itr.next();
			if (visited[j] == false)
				DFS(graph, j, visited, dest, s);

		}
		visited[i] = false;

	}
}
