import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RoadsAndLibraries {
	static int count = 0;

	// Complete the roadsAndLibraries function below.
	static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

		GraphR graph = new GraphR(n);
		for (int i = 0; i < cities.length; i++) {
			graph.add(cities[i][0] - 1, cities[i][1] - 1);
		}
		System.out.println("c_lib= " + c_lib);
		System.out.println("n= " + n);
		long min = (c_lib * n);
		System.out.println("min= "+min);
		long sum = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				count = 0;
				canBeVisited(graph, visited, i, n);
				sum = sum + (count * c_road) + c_lib;
				System.out.println("sum= " + sum);

			}

		}
		System.out.println("sum= " + sum + " min =" + min);
		if (sum < min) {
			return sum;
		} else {
			return min;
		}

	}

	private static void canBeVisited(GraphR graph, boolean[] visited, int u, int n) {
		visited[u] = true;
		List<Integer> list = graph.adj[u];
		if (list == null) {
			return;
		}
		for (int v : list) {
			if (visited[v] == false) {
				count = count + 1;
				canBeVisited(graph, visited, v, n);
			}

		}

	}

	private static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = s.nextInt();
		for (int z = 0; z < t; z++) {
			int n = s.nextInt();
			int m = s.nextInt();
			int c_lib = s.nextInt();
			int c_road = s.nextInt();
			int[][] cities = new int[m][2];

			for (int i = 0; i < m; i++) {
				cities[i][0] = s.nextInt();
				cities[i][1] = s.nextInt();

			}
			long result = roadsAndLibraries(n, c_lib, c_road, cities);
			System.out.println(result);

		}

	}
}

class GraphR {
	int v;
	LinkedList[] adj;

	public GraphR(int v) {
		this.v = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adj[i] = new LinkedList<Integer>();

		}

	}

	public void add(int u, int v) {
		this.adj[u].add(v);
		this.adj[v].add(u);
	}

}
