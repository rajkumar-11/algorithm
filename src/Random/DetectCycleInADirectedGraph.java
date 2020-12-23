import java.util.Iterator;
import java.util.Stack;

public class DetectCycleInADirectedGraph {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		// graph.addEdge(2, 3);
		// graph.addEdge(3, 3);

		if (isThereACycle(graph))
			System.out.println("yes there is a cycle");
		else
			System.out.println("no there is no cycle");

	}

	private static boolean isThereACycle(DirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false) {
				if (DFS(graph, visited, stack, i))
					return true;
			}

		}
		return false;

	}

	private static boolean DFS(DirectedGraph graph, boolean[] visited, Stack<Integer> stack, int i) {
		visited[i] = true;
		stack.add(i);

		Iterator<Integer> itr = graph.adjList[i].iterator();
		while (itr.hasNext()) {
			int j = itr.next();

			if (visited[i] == false) {
				DFS(graph, visited, stack, i);
			} else {
				if (stack.contains(j))
					return true;
			}

		}
		stack.pop();
		return false;

	}
}
