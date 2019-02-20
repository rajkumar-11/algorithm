
public class MColoringProblem {

	static int V = 4;
	static int[] color;
	static int m = 2;

	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, };

		// int m = 2;

		if (grpahColoring(graph, m)) {
			for (int i = 0; i < V; i++) {
				System.out.print(color[i] + " ");
			}
		} else
			System.out.println(-1);

	}

	private static boolean grpahColoring(int[][] graph, int m) {
		color = new int[V];

		if (graphColorUtil(graph, color, 0))
			return true;
		else
			return false;

	}

	private static boolean graphColorUtil(int[][] graph, int[] color, int v) {
		if (V == v)
			return true;

		for (int i = 1; i <= m; i++) {
			if (isSafe(graph, i, v, color)) {
				color[v] = i;
				if (graphColorUtil(graph, color, v + 1))
					return true;

				color[v] = 0;

			}
		}

		return false;
	}

	private static boolean isSafe(int[][] graph, int c, int v, int[] color) {
		for (int j = 0; j < V; j++) {
			if (graph[v][j] != 0 && color[j] == c)
				return false;

		}

		return true;
	}

}
