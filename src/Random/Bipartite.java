import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

	public static void main(String[] args) {
		int G[][] = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } };

		if (isBipartite(G))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private static boolean isBipartite(int[][] g) {
		int visited[] = new int[4];

		for (int i = 0; i < 4; i++) {
			visited[i] = -1;
		}
		for (int i = 0; i < 4; i++) {
			if (visited[i] == 0) {
				if (checkBiparte(g, visited, i) == false) {
					return false;
				}
			}

		}

		return true;
	}

	private static boolean checkBiparte(int[][] g, int[] visited, int i) {
		visited[i] = 1;

		if (g[i][i] == 1)
			return false;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);

		Iterator<Integer> itr = queue.iterator();

		while (!queue.isEmpty()) {
			int u = queue.poll();

			for (int v = 0; v < 4; v++) {
				if (g[u][v] == 1 && visited[v] == 0) {
					queue.add(v);
					visited[v] = 1 - visited[u];
				} else if (g[u][v] == 1 && visited[v] == visited[u])
					return false;

			}

		}

		return true;
	}

}
