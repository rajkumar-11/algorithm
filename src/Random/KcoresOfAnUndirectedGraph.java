import java.util.Iterator;

public class KcoresOfAnUndirectedGraph {

	public static void main(String[] args) {
		int k = 3;
		UnDirectedGraph graph = new UnDirectedGraph(9);

		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 2);
		graph.add(1, 5);
		graph.add(2, 3);
		graph.add(2, 4);
		graph.add(2, 5);
		graph.add(2, 6);
		graph.add(3, 4);
		graph.add(3, 6);
		graph.add(3, 7);
		graph.add(4, 6);
		graph.add(4, 7);
		graph.add(5, 6);
		graph.add(5, 8);
		graph.add(6, 7);
		graph.add(6, 8);

		printKCores(k, graph);

	}

	private static void printKCores(int k, UnDirectedGraph graph) {
		int[] degree = new int[graph.V];

		int minIndex = Integer.MAX_VALUE;
		int startVertex = 0;

		for (int i = 0; i < graph.V; i++) {
			degree[i] = graph.adjList[i].size();

			if (degree[i] < minIndex) {
				minIndex = degree[i];
				startVertex = i;

			}

		}
		System.out.println("starting vertex= " + startVertex + "minIndex= " + minIndex);
		boolean[] visited = new boolean[graph.V];

		// DFS(startVertex,graph,visited,degree,k);

		for (int i = 0; i < graph.V; i++)
		{   
			if(visited[i]==false)
			DFS(i, graph, visited, degree, k);
		}

		for (int i = 0; i < graph.V; i++) {
			if (degree[i] >= k) {
				System.out.print("[" + i + "]  ->");

				Iterator<Integer> itr = graph.adjList[i].iterator();

				while (itr.hasNext()) {
					int j = itr.next();

					if (degree[j] >= k)
						System.out.print(j + " ->");
				}
				System.out.println();

			}

		}
		for (int i = 0; i < graph.V; i++) {
			System.out.println(i + "  " + degree[i]);

		}

	}

	private static boolean DFS(int v, UnDirectedGraph graph, boolean[] visited, int[] degree, int k) {
		visited[v] = true;
		if (degree[v] < k) {
			// degree[v]--;
			Iterator<Integer> itr = graph.adjList[v].iterator();

			while (itr.hasNext()) 
			{
				int i = itr.next();
				degree[i]--;

				if (visited[i] == false) {
					if (DFS(i, graph, visited, degree, k)) {
						degree[v]--;

					}
				}

			}

		}

		return degree[v] < k;

	}

}
