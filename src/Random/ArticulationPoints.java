import java.util.Iterator;

public class ArticulationPoints {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(6);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 3);
		graph.add(3, 4);
		graph.add(3, 5);
		graph.add(2, 3);
		graph.add(4, 5);

		AP(graph);

	}

	private static void AP(UnDirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];
		int[] parent = new int[graph.V];
		int[] low = new int[graph.V];
		int[] dist = new int[graph.V];
		int time = 0;
		boolean[] articulation = new boolean[graph.V];

		for (int i = 0; i < graph.V; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false) {
				DFS(visited, parent, low, dist, articulation, i, time, graph);

			}

		}
		
		for(int i=0;i<graph.V;i++)
		{
			if(articulation[i]==true)
				System.out.print(i+" ");
		}

	}

	private static void DFS(boolean[] visited, int[] parent, int[] low, int[] dist, boolean[] articulation, int u,
			int time, UnDirectedGraph graph) {
		visited[u] = true;
		dist[u] = low[u] = ++time;
		int child = 0;

		Iterator<Integer> itr = graph.adjList[u].iterator();

		while (itr.hasNext()) {
			int v = itr.next();
			


			if (visited[v] == false)
			{
				child++;
				parent[v] = u;
				DFS(visited, parent, low, dist, articulation, v, time, graph);

				low[u] = Math.min(dist[u], low[v]);

				if (child >= 2 && parent[u] == -1)
					System.out.println("first= "+u);
					articulation[u] = true;

				if (parent[u] != -1 && low[v] >= dist[u]) {
					System.out.println("second= "+u);
					articulation[u] = true;
				}

			}
			 else if (v != parent[u])
	                low[u]  = Math.min(low[u], dist[v]);

		}

	}

}
