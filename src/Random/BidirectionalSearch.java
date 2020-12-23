import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BidirectionalSearch {
	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(15);

		int s = 0;

		int t = 14;

		graph.add(0, 4);
		graph.add(1, 4);
		graph.add(2, 5);
		graph.add(3, 5);
		graph.add(4, 6);
		graph.add(5, 6);
		graph.add(6, 7);
		graph.add(7, 8);
		graph.add(8, 9);
		graph.add(8, 10);
		graph.add(9, 11);
		graph.add(9, 12);
		graph.add(10, 13);
		graph.add(10, 14);

		if (BiDirectionalSearch(s, t, graph) == -1) {
			System.out.println("path dont exist");

		}

	}

	private static int BiDirectionalSearch(int s, int t, UnDirectedGraph graph) {
		Queue<Integer> squeue = new LinkedList<>();
		Queue<Integer> tqueue = new LinkedList<>();

		squeue.add(s);
		tqueue.add(t);

		boolean[] svisited = new boolean[graph.V];
		boolean[] tvisited = new boolean[graph.V];

		int[] sparent = new int[graph.V];
		int[] tparent = new int[graph.V];

		int intersect = -1;

		svisited[s] = true;
		tvisited[t] = true;
		tparent[t] = -1;
		sparent[s] = -1;

		while (!squeue.isEmpty() && !tqueue.isEmpty()) {

			BFS(squeue, graph, svisited, sparent);
			BFS(tqueue, graph, tvisited, tparent);

			intersect = isIntersected(svisited, tvisited, graph);

			if (intersect != -1) {
				System.out.println("There is path between source and destination");
				printpath(sparent, tparent, intersect, s, t);

				return 0;
			}

		}

		return -1;
	}

	private static void printpath(int[] sparent, int[] tparent, int intersect, int s, int t) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(intersect);
		System.out.println("sparent length= " + sparent.length);
		System.out.println("tparent length= " + tparent.length);

		int i = intersect;

		while (i != s) {
			list.add(sparent[i]);
			i = sparent[i];
		}
		list.add(i);

		Collections.reverse(list);
		i = intersect;

		while (i != t) {
			list.add(tparent[i]);
			i = tparent[i];

		}

		for (int x = 1; x < list.size(); x++) {
			System.out.print(list.get(x) + " ");

		}

	}

	private static int isIntersected(boolean[] svisited, boolean[] tvisited, UnDirectedGraph graph) {
		for (int i = 0; i < graph.V; i++) {
			if (svisited[i] && tvisited[i]) {
				System.out.println("i= " + i);
				return i;

			}

		}

		return -1;
	}

	private static void BFS(Queue<Integer> queue, UnDirectedGraph graph, boolean[] visited, int[] parent) {
		int current = queue.poll();
		Iterator<Integer> itr = graph.adjList[current].iterator();

		while (itr.hasNext()) {
			int j = itr.next();

			if (visited[j] == false) {
				parent[j] = current;
				visited[current] = true;
				queue.add(j);
			}

		}

	}

}
