
public class PrimsMSTMatrix {
	static int V = 5;

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 }, };

		primsMST(graph);
	}

	private static void primsMST(int[][] graph)
	{
		boolean[] mset = new boolean[V];
		int[] key = new int[V];

		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;

		}

		int[] parent = new int[V];

		key[0] = 0;
		parent[0] = -1;

		for (int i = 0; i < V - 1; i++) {
			int u = min(key, mset);
			mset[u]=true;

			for (int v = 0; v < V; v++)
			{
				if (graph[u][v] != 0 && mset[v] == false && key[v] > graph[u][v]) {
					key[v] = graph[u][v];
					parent[v] = u;

				}

			}

		}
		
		for(int i=1;i<V;i++)
		{
			System.out.println(i+" to "+parent[i]+" with weight "+key[i]);
		}
		
		

	}

	private static int min(int[] key, boolean[] mset) {
		int min_index = -1, min_value = Integer.MAX_VALUE;

		for (int i = 0; i < V; i++) {
			if (mset[i] == false && key[i] < min_value)
				{
				min_index = i;
				min_value = key[i];

			}

		}
//		System.out.println("min_index ="+min_index);

		return min_index;
	}

}
