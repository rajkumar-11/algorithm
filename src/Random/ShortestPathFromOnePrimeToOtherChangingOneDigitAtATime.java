import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathFromOnePrimeToOtherChangingOneDigitAtATime {
	public static void main(String[] args) {
		int num1 = 1033, num2 = 8179;

		System.out.println(shortestPath(num1, num2));

	}

	private static int shortestPath(int num1, int num2) {
		List<Integer> list = sieveOfErasthenes(9999);
		int n = list.size();

		int[] arr = new int[n];

		UnDirectedGraph graph = new UnDirectedGraph(n);

		for (int i = 0; i < n; i++) {
			arr[i] = list.get(i);

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// System.out.println((String.valueOf(arr[i])+" "+);
				if (compare(String.valueOf(arr[i]), String.valueOf(arr[j]))) {

					graph.add(i, j);
				}

			}
		}

		return bfs(graph, num1, num2, arr);
	}

	private static int bfs(UnDirectedGraph graph, int num1, int num2, int[] arr) {
		int x = 0, y = 0;

		System.out.println(Arrays.toString(arr));

		for (int i = 0; i < graph.V; i++) {
			if (arr[i] == num1) {
				x = i;
				break;
			}

		}
		for (int i = 0; i < graph.V; i++) {
			if (arr[i] == num2) {
				y = i;
				break;
			}

		}
		System.out.println("here x=  " + x + "  y= " + y + "  num1= " + num1 + "num2= " + num2 + "n= " + graph.V);

		int[] visited = new int[graph.V];

		Queue<Integer> queue = new LinkedList<>();

		queue.add(x);
		visited[x] = 1;

		while (!queue.isEmpty()) {
			int temp = queue.poll();
//			System.out.println("temp= " + temp);
			Iterator<Integer> itr = graph.adjList[temp].iterator();
			while (itr.hasNext()) {
				// sysout
				int z = itr.next();
				if (visited[z] == 0) {
					visited[z] = visited[temp] + 1;
					queue.add(z);

				}
				// System.out.println("z= " + z);
				if (z == y) {
					System.out.println("here");
					return visited[z] - 1;
				}

			}

		}

		return 0;
	}

	private static boolean compare(String v1, String v2) {
		int c = 0;
		// System.out.println(v1.charAt(0));
		if (v1.charAt(0) != v2.charAt(0))
			c++;
		if (v1.charAt(1) != v2.charAt(1))
			c++;
		if (v1.charAt(2) != v2.charAt(2))
			c++;
		if (v1.charAt(3) != v2.charAt(3))
			c++;
		// System.out.println("c= "+c);

		if (c == 1)
			return true;

		return false;
	}

	private static List<Integer> sieveOfErasthenes(int n) {

		int[] arr = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) {
				int p = 2;

				while (i * p <= n) {
					arr[i * p] = 1;
					p++;
				}

			}

		}

		List<Integer> list = new ArrayList<>();

		for (int i = 1001; i < 10000; i++) {
			if (arr[i] == 0) {
				list.add(i);
			}

		}

		return list;
	}

}
