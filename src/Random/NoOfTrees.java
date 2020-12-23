import java.util.Iterator;

public class NoOfTrees {

	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(6);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(3, 5);
		// graph.add(0, 1);
		int count = counttrees(graph);
		System.out.println(count);

	}

	private static int counttrees(UnDirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];
		int count = 0;
		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false) {
				dfs(graph, visited, i);
				count++;
			}

		}

		return count;
	}

	private static void dfs(UnDirectedGraph graph, boolean[] visited, int i) {
		visited[i] = true;

		Iterator<Integer> itr = graph.adjList[i].iterator();

		while (itr.hasNext()) {
			int j = itr.next();

			if (visited[j] == false)
				dfs(graph, visited, j);

		}

	}

}
