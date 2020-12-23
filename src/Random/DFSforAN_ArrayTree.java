import java.util.Iterator;

public class DFSforAN_ArrayTree {

	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(5);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 3);
		graph.add(2, 4);

		boolean visited[] = new boolean[5];

		Dfs(graph, visited, 0);

	}

	private static void Dfs(UnDirectedGraph graph, boolean[] visited, int i) {
		Iterator<Integer> itr = graph.adjList[i].iterator();

		visited[i] = true;
		System.out.print(i + " ");

		while (itr.hasNext()) {
			int j = itr.next();

			if (visited[j] == false) {
				Dfs(graph, visited, j);

			}

		}

	}
}
