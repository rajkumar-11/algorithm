import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AllPathsFromSourceToDestinationUsingBFS {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(4);
		graph.addEdge(0, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(0, 3);
		graph.addEdge(0, 1);

		printPaths(graph, 2, 3);
	}

	private static void printPaths(DirectedGraph graph, int src, int dest) {
		boolean visited[] = new boolean[graph.V];

		Queue<LinkedList<Integer>> queue = new LinkedList<>();

		LinkedList<Integer> path = new LinkedList<>();

		path.add(src);

		queue.add(path);

		while (!queue.isEmpty()) {
			path = queue.poll();

			int last = path.getLast();

			if (last == dest) {
				printpath(path);
			}

			Iterator<Integer> itr = graph.adjList[last].iterator();

			while (itr.hasNext()) {
				int j = itr.next();

				if (isvisited(path, j)) {
					LinkedList<Integer> newpath = new LinkedList<>();
					for (int i = 0; i < path.size(); i++) {
						newpath.add(path.get(i));
					}
					newpath.add(j);
					queue.add(newpath);

				}

			}

		}

	}

	private static boolean isvisited(LinkedList<Integer> path, int j) {
		for (int i = 0; i < path.size(); i++) {
			if (path.get(i) == j)
				return false;
		}

		return true;
	}

	private static void printpath(LinkedList<Integer> path) {
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i));
		}
		System.out.println();
	}

}
