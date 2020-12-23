import java.util.Arrays;

public class HamiltonianCycleUsingBackTracking {
	static int V = 5;

	public static void main(String[] args) {
		int graph1[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0 }, };
		HamiltonCycle(graph1, 5);

	}

	private static void HamiltonCycle(int[][] graph1, int v) {
		int[] path = new int[v];

		Arrays.fill(path, -1);

		path[0] = 1;

		if (hamiltonUtil(graph1, path, 1) == false) {
			System.out.println("There is no hamilton cycle");
		} else {
			for (int i = 0; i < v; i++) {
				System.out.print(path[i] + " ");

			}
			System.out.println(path[0]);
		}

	}

	private static boolean hamiltonUtil(int[][] graph, int[] path, int pos) {

		if (pos == V) {
			// System.out.println("putai ke");
			if (graph[path[pos - 1]][path[0]] == 1)
				return true;
			else
				return false;

		}

		for (int i = 1; i < V; i++)
		{
			if (isSafe(i, graph, path, pos))
			{

				path[pos] = i;

				if (hamiltonUtil(graph, path, pos + 1) == true)
					return true;

				path[pos] = -1;

			}

		}

		System.out.println("jai shree ram");
		return false;
	}

	private static boolean isSafe(int v, int[][] graph, int[] path, int pos) {
		System.out.println("ram");
		if (graph[path[pos - 1]][v] == 0)
			return false;

		for (int i = 0; i < pos; i++) {
			if (path[i] == v)
				return false;

		}

		return true;
	}
}
