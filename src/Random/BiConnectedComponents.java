import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class BiConnectedComponents {
	static int count = 0;

	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(12);
		graph.add(0, 1);
		graph.add(1, 2);
		graph.add(1, 3);
		graph.add(2, 3);
		graph.add(2, 4);
		graph.add(3, 4);
		graph.add(1, 5);
		graph.add(0, 6);
		graph.add(5, 6);
		graph.add(5, 7);
		graph.add(5, 8);
		graph.add(7, 8);
		graph.add(8, 9);
		graph.add(10, 11);

		BinaryConnectedComponents(graph);

		System.out.println("The total number of connected Componentes possible is = " + count);

	}

	private static void BinaryConnectedComponents(UnDirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];

		int[] low = new int[graph.V];
		int[] dist = new int[graph.V];
		int[] parent = new int[graph.V];

		LinkedList<EdgeSD> stack = new LinkedList<>();

		for (int i = 0; i < graph.V; i++) {
			parent[i] = -1;
			dist[i] = -1;
			low[i] = -1;
		}

		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false) {
				DFSUtils(graph, i, low, dist, parent, visited, stack, 0);
			}

			int j = 0;

			// If stack is not empty, pop all edges from stack
			while (stack.size() > 0) {
				j = 1;
				// System.out.println("stack.size= " + stack.size());
				System.out.print(stack.getLast().src + "--" + stack.getLast().dest + " ");
				stack.removeLast();
			}
			if (j == 1) {
				System.out.println();
				// System.out.println("jai shree ram");
				count++;
			}

		}

	}

	private static void DFSUtils(UnDirectedGraph graph, int u, int[] low, int[] dist, int[] parent, boolean[] visited,
			LinkedList<EdgeSD> stack, int time) {
		visited[u] = true;
		int child = 0;

		dist[u] = low[u] = ++time;

		Iterator<Integer> itr = graph.adjList[u].iterator();

		while (itr.hasNext()) {
			int v = itr.next();

			if (visited[v] == false) {
				child++;
				parent[v] = u;
				stack.add(new EdgeSD(u, v));
				// System.out.println("u= " + u + " v= " + v);

				DFSUtils(graph, v, low, dist, parent, visited, stack, time);

				low[u] = Math.min(low[u], low[v]);
				// System.out.println("uAfter= " + u + " vAfter= " + v);

				if ((parent[u] == -1 && child >= 2) || (parent[u] != -1 && dist[u] <= low[v])) {
					// System.out.println("condition satisfied" + " u=" + u + "
					// v= " + v);
					while (stack.getLast().src != u || stack.getLast().dest != v) {
						// SYSTEM.OUT.PRINTLN("STACK SIZE= " + STACK.SIZE() +
						// "SRC= " + STACK.GETLAST().SRC + " DEST= "
						// + stack.getLast().dest);
						System.out.print(stack.getLast().src + " -- " + stack.getLast().dest + "  ");
						stack.removeLast();
					}
					System.out.println(stack.getLast().src + " -- " + stack.getLast().dest + "  ");
					stack.removeLast();
					count++;
					// sSystem.out.println("size= " + stack.size());

				}

			} else if (v != parent[u] && dist[v] < low[u]) {

				if (low[u] > dist[v])
					low[u] = dist[v];
				// System.out.println("added u and v 2 ="+u+" "+v);
				stack.add(new EdgeSD(u, v));
				// System.out.println("u2= " + u + " v2= " + v);

			}

		}

	}

}
