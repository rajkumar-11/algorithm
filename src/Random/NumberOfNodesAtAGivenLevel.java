import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfNodesAtAGivenLevel {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(6);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 3);
		graph.add(2, 4);
		graph.add(2, 5);
		int level = 2;
		System.out.println(levelCount(graph, level, 0));
	}

	private static int levelCount(UnDirectedGraph graph, int level, int starts) {
		boolean visited[] = new boolean[graph.V];

		Queue<Integer> queue = new LinkedList<>();

		queue.add(starts);

		int[] levels = new int[graph.V];
		while (!queue.isEmpty()) {
			int x = queue.poll();
//			System.out.println("x= "+x);
			visited[x]=true;

			Iterator<Integer> itr = graph.adjList[x].iterator();

			while (itr.hasNext()) {
				int i = itr.next();
				if (visited[i] == false) {
					levels[i] = levels[x] + 1;
					queue.add(i);
					

				}

			}

		}
		int count = 0;
		for (int i = 0; i < graph.V; i++) {
			if (levels[i] == level)
				count++;

		}

		return count;
	}

}
