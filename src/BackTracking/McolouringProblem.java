package BackTracking;

public class McolouringProblem {
	static int V = 4;

	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };

		int m = 3;

		graphColouring(graph, m);

	}

	private static void graphColouring(int[][] graph, int m) {
		int[] color = new int[V];

		if (isColouringPossible(graph, color, 0, m))
			{System.out.println("yes the colouring possible");
			  for(int i=0;i<V;i++)
			  {
				  System.out.print(color[i]+" ");
			  }
			
			}
		else
			System.out.println("The colouring is not possible");

	}

	private static boolean isColouringPossible(int[][] graph, int[] color, int v, int m) {
		if (v == V)
			return true;

		for (int c = 1; c <= m; c++) {
			if (isSafe(graph, color, v, c)) {
				color[v] = c;

				if (isColouringPossible(graph, color, v + 1, m))
					return true;

				color[v] = 0;

			}

		}

		return false;
	}

	private static boolean isSafe(int[][] graph, int[] color, int v, int c) {
		for (int i = 0; i < V; i++) {
			if (graph[v][i] == 1 && c == color[i])
			{
              return false;
				
				
			}

		}

		return true;
	}
}
