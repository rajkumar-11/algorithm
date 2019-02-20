package Misc;

import java.util.Iterator;

public class SnakeAndLadderProblem {
	public static void main(String[] args) {
		int N = 25;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		// moves[26] = 0;
		// moves[20] = 8;
		// moves[16] = 3;
		// moves[18] = 6;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));

	}

	private static int getMinDiceThrows(int[] moves, int n) {
		DirectedGraph graph = new DirectedGraph(n + 1);

		for (int i = 1; i < n; i++) {
			graph.addEdge(i, i + 1);
			if (i + 2 <= n)
				graph.addEdge(i, i + 2);
			if (i + 3 <= n)
				graph.addEdge(i, i + 3);
			if (i + 4 <= n)
				graph.addEdge(i, i + 4);
			if (i + 5 <= n)
				graph.addEdge(i, i + 5);
			if (i + 6 <= n)
				graph.addEdge(i, i + 6);

			if (moves[i] != -1) {
				graph.addEdge(i, moves[i]);
			}

		}
		boolean[] visited = new boolean[n + 1];

		// for (int i = 0; i < n; i++) {
		// System.out.println(graph.adjList[i].size());
		//
		// }

		int result = minValue(graph, 1, n, visited);

		return result;
	}

	private static int minValue(DirectedGraph graph, int u, int n, boolean[] visited) {

		// IF (VISITED[U] == TRUE)
		// RETURN 3432;

		System.out.println("u= " + u);

		if (u > n)
			return 0;

		if (u == n)
			return 1;

		// visited[u] = true;
		System.out.println("size= " + graph.adjList[u].size() + " u=" + u);

		Iterator<Integer> itr = graph.adjList[u].iterator();

		int min = 544654;
		while (itr.hasNext()) {
			int v = itr.next();

			int temp = 1 + minValue(graph, v, n, visited);
			// System.out.println("temp= " + temp);

			if (temp < min)
				min = temp;

		}
		// visited[u] = false;

		System.out.println("min= " + min);
		return min + 1;
	}
}
