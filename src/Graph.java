import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {
	static LinkedList[] adjList = null;

	public static void main(String[] args)
	{
		int v = 5;
		Graph graph = new Graph(v);
		graph.add(0, 1);
		graph.add(0, 4);
		graph.add(1, 4);
		graph.add(4, 3);
		graph.add(1, 3);
		graph.add(2, 3);
		graph.add(2, 1);

		for (int i = 0; i < v; i++) {
			Iterator<Integer> itr = adjList[i].iterator();
			System.out.print(i + "-> ");
			while (itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
		}

	}

	@SuppressWarnings("unchecked")
	void add(int i, int j) {
		adjList[i].add(j);

	}

	public Graph(int v) {
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<Integer>();

		}

	}

	public void BFS(int i, int v) {
		boolean[] visited = new boolean[v];

		LinkedList<Integer> list = new LinkedList<>();
		list.add(i);
		while (!list.isEmpty()) {
			int x = list.pollFirst();
			visited[x] = true;
			System.out.print(x + " ");
			Iterator<Integer> itr = adjList[x].iterator();
			System.out.println("here");
			while (itr.hasNext()) {
				int y = itr.next();

				if (!visited[y]) {
					list.add(y);
				}

			}

		}

	}

	public void DFS(int i, boolean[] visited) {
		System.out.print(i + " ");
		visited[i] = true;
		Iterator<Integer> itr = adjList[i].iterator();
		while (itr.hasNext()) {
			int y = itr.next();
			if (!visited[y]) {
				DFS(y, visited);
			}

		}

	}

	public void DFSDisconnected(int i, boolean[] visited) {

		System.out.print(i + " ");
		visited[i] = true;
		Iterator<Integer> itr = adjList[i].iterator();
		while (itr.hasNext()) {
			int y = itr.next();
			if (!visited[y]) {
				DFSDisconnected(y, visited);
			}

		}

	}

	public void topologicalSort(int i, boolean[] visited, Stack<Integer> stack) {
		Iterator itr = adjList[i].iterator();
		visited[i] = true;

		while (itr.hasNext()) {
			int x = (int) itr.next();

			if (!visited[x]) {

				topologicalSort(x, visited, stack);

			}

		}

		stack.push(i);

	}

	public boolean isCyclic(int v) {
		boolean[] stack = new boolean[v];
		boolean[] visited = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (isCyclicUtil(i, stack, visited))
				return true;
		}
		return false;

	}

	private boolean isCyclicUtil(int i, boolean[] stack, boolean[] visited) {
		if (stack[i])
			return true;
		if (visited[i])
			return false;

		stack[i] = true;
		visited[i] = true;

		Iterator<Integer> itr = adjList[i].iterator();
		while (itr.hasNext()) {
			int y = itr.next();

			if (isCyclicUtil(y, stack, visited))
				return true;

		}
		stack[i] = false;

		return false;
	}

}
