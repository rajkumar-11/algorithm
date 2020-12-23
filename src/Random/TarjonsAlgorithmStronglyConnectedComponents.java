import java.util.Iterator;
import java.util.Stack;

public class TarjonsAlgorithmStronglyConnectedComponents {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		System.out.println("SSC in first graph " + SSC(graph));

	}

	private static int SSC(DirectedGraph graph) {
		int[] disc = new int[graph.V];
		int[] low = new int[graph.V];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < graph.V; i++) {
			disc[i] = -1;
			low[i] = -1;

		}
		int time = 1;

		for (int i = 0; i < graph.V; i++) {
			if (disc[i] == -1) {
				SSCUtil(i, disc, low, graph, stack, time);

			}

		}

		return 0;
	}

	private static void SSCUtil(int u, int[] disc, int[] low, DirectedGraph graph, Stack<Integer> stack, int time) {
		disc[u] = time;
		low[u] = time;
		time = time + 1;
		stack.add(u);
		// System.out.println("u= " + u);

		Iterator<Integer> itr = graph.adjList[u].iterator();

		while (itr.hasNext()) 
		{
			int v = itr.next();

			if (disc[v] == -1) {
				SSCUtil(v, disc, low, graph, stack, time);
				low[u] = Math.min(low[u], low[v]);

			} else if (stack.contains(v)) {

				low[u] = Math.min(low[u], disc[v]);

			}

		}
		if (low[u] == disc[u]) {
			// System.out.println("size= " + stack.size() + " u=" + u);
			while (stack.peek() != u) {

				System.out.print(stack.pop() + " ");

			}
			System.out.print(stack.pop() + " ");
			System.out.println();
			// System.out.println("abc");

		}

	}
}
