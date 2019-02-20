
public class IsBiConnected {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(5);
		graph.add(1, 0);
		graph.add(0, 2);
		graph.add(2, 1);
		graph.add(0, 3);
		graph.add(3, 4);
		graph.add(2, 4);

		if (isBC(graph))
			System.out.println("yes");
		else
			System.out.println("no");

	}

	private static boolean isBC(UnDirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];
		int[] disc = new int[graph.V];
		int[] low = new int[graph.V];
		int[] parent = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false) {
				// DFS()

			}

		}

		return false;
	}
}
