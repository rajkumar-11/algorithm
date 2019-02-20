import java.util.Iterator;

enum color {
	white(0), gray(1), black(2);

	private int value;

	private color(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

public class DetectCycleUsingColor {

	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (isCyclic(graph)) {
			System.out.println("Yes there is a cycle");
		} 
		else
		{
			System.out.println("No there is no cycle");
		}

	}

	private static boolean isCyclic(DirectedGraph graph) {
		int[] arr = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			if (cyclicUtils(graph, arr, i))
				return true;
		}
		return false;
	}

	private static boolean cyclicUtils(DirectedGraph graph, int[] arr, int i) {
		arr[i] = color.gray.getValue();

		Iterator<Integer> itr = graph.adjList[i].iterator();

		while (itr.hasNext()) {
			int x = itr.next();

			if (arr[x] == 1)
				return true;
			if (arr[x] == 0 && cyclicUtils(graph, arr, x)) {
				return true;
			}

		}

		arr[i] = 2;

		return false;
	}

}
