import java.util.Iterator;
import java.util.Stack;

public class StronglyConnectedComponent {
	public static void main(String[] args) {

		DirectedGraph graph = new DirectedGraph(5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);

		StronglyConnectedComponents(graph);
	}

	private static void StronglyConnectedComponents(DirectedGraph graph) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[graph.V];

		for (int i = 0; i < graph.V; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false)
				DFS(stack, graph, visited, i);
		}

		for (int i = 0; i < graph.V; i++) {
			visited[i] = false;
		}

		DirectedGraph graphTranpose = TransposeGraph(graph, stack, visited);

		// System.out.println("stack= " + stack);
		while (!stack.isEmpty()) {
			int i = stack.pop();
			if (visited[i] == false) {
				SCC(graphTranpose, visited, i);
				System.out.println();
			}
		}

	}

	private static void SCC(DirectedGraph graphTranpose, boolean[] visited, int index) {
		System.out.print(index + " ");
		visited[index] = true;
		Iterator<Integer> itr = graphTranpose.adjList[index].iterator();
		while (itr.hasNext()) {
			int i = itr.next();

			if (visited[i] == false) {
				SCC(graphTranpose, visited, i);
			}

		}

	}

	@SuppressWarnings("unchecked")
	private static DirectedGraph TransposeGraph(DirectedGraph graph, Stack<Integer> stack, boolean[] visited) {
		DirectedGraph graphTranpose = new DirectedGraph(graph.V);
		for (int i = 0; i < graph.V; i++) {
			Iterator<Integer> itr = graph.adjList[i].iterator();
			while (itr.hasNext()) {
				int j = itr.next();
				graphTranpose.adjList[j].add(i);

			}

		}
		return graphTranpose;

	}

	private static void DFS(Stack<Integer> stack, DirectedGraph graph, boolean[] visited, int index) {
		Iterator<Integer> itr = graph.adjList[index].iterator();
		visited[index] = true;

		while (itr.hasNext()) {
			int i = itr.next();
			System.out.println("i= " + i);
			if (visited[i] == false) {
				DFS(stack, graph, visited, i);
			}

		}
		stack.push(new Integer(index));
	}

}
