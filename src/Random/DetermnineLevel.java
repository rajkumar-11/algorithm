import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DetermnineLevel {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(8);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 3);
		graph.add(1, 4);
		graph.add(1, 5);
		graph.add(2, 6);
		graph.add(6, 7);

		int[] level = new int[8];

		determineLevel(graph, level);
		for (int i = 0; i < graph.V; i++) {
			System.out.println(i + "  " + level[i]);

		}

	}

	private static void determineLevel(UnDirectedGraph graph, int[] level) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.V];
		visited[0] = true;
		queue.add(0);

		while (!queue.isEmpty()) {
			int j = queue.remove();
			visited[j] = true;
			System.out.println("queue size= " + queue.size());
			Iterator<Integer> iterator = graph.adjList[j].iterator();
			while (iterator.hasNext()) {
				int x = iterator.next();
				if (visited[x] == false) {
					queue.add(x);
					level[x] = level[j] + 1;
				}
			}
		}

	}

}
