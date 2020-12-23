import java.util.Iterator;
import java.util.Stack;

public class CheckIfAGivenGraphIsTreeorNot {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(5);
		graph.add(1, 0);
		graph.add(0, 2);
		graph.add(0, 3);
		graph.add(3, 4);

		if (isTree(graph))
			System.out.println("yes the graph is tree");
		else
			System.out.println("no the graph is not tree");

	}

	private static boolean isTree(UnDirectedGraph graph) {
		boolean[] visited = new boolean[graph.V];

		Stack<Integer> stack = new Stack<>();

		if (DFS(graph, visited, stack, 0)) {
			System.out.println("here");
			return false;

		} else {
			for (int i = 0; i < graph.V; i++) {

				if (visited[i] == false) {
					System.out.println("here2 i= " + i);
					return false;

				}
			}

		}

		return true;
	}

	private static boolean DFS(UnDirectedGraph graph, boolean[] visited, Stack<Integer> stack, int i) {
		visited[i] = true;
		Iterator<Integer> itr = graph.adjList[i].iterator();
		System.out.println(i + "  size=" + graph.adjList[i].size());
		stack.add(i);
		while (itr.hasNext())
		{
			int j = itr.next();
			System.out.println("j= " + j + " i= " + i);
			if (visited[j] == false)
			{
				DFS(graph, visited, stack, j);
			} else {
				if (stack.contains(j))
					return true;
			}

		}

		stack.pop();

		return false;
	}
}
