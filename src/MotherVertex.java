import java.util.Iterator;
import java.util.Stack;

public class MotherVertex {

	public static void main(String[] args) {

		DirectedGraph graph = new DirectedGraph(7);
		graph.addEdge(0, 2);
		graph.addEdge(5, 2);
		graph.addEdge(5, 6);
		graph.addEdge(6, 4);
		graph.addEdge(4, 1);
		graph.addEdge(1, 3);
		graph.addEdge(6, 0);
		graph.addEdge(0, 1);
		MotherVertex(graph);

	}

	private static void MotherVertex(DirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false) {
				DFS(graph, stack, i, visited);
			}

		}

		for (int i = 0; i < graph.V; i++) {
			visited[i] = false;

		}
		int x = stack.pop();

		DFS(graph, x, visited);
		boolean flag = true;

		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false) {
				flag = false;
				break;
			}

		}

		if (flag == false) {
			System.out.println("There is no mother vertex");
		} else {
			System.out.println(x + "  is the mother vertex");
		}

	}

	private static void DFS(DirectedGraph graph, Integer i, boolean[] visited) {
		visited[i] = true;
		Iterator<Integer> itr = graph.adjList[i].iterator();

		while (itr.hasNext()) {
			int j = itr.next();
			if (visited[j] == false) {
				DFS(graph, j, visited);
			}

		}

	}

	private static void DFS(DirectedGraph graph, Stack<Integer> stack, int i, boolean[] visited) {
		visited[i] = true;
		Iterator<Integer> itr = graph.adjList[i].iterator();

		while (itr.hasNext()) {
			int j = itr.next();
			if (visited[j] == false) {
				DFS(graph, stack, j, visited);
			}

		}
		stack.push(i);

	}

}
