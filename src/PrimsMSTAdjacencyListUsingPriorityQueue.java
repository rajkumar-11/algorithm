import java.util.Iterator;

public class PrimsMSTAdjacencyListUsingPriorityQueue {
	public static void main(String[] args) {
		UnDirectedWeightedGraph graph = new UnDirectedWeightedGraph(9);
		graph.add(0, 1, 4);
		graph.add(0, 7, 8);
		graph.add(1, 2, 8);
		graph.add(1, 7, 11);
		graph.add(2, 8, 2);
		graph.add(2, 3, 7);
		graph.add(2, 5, 4);
		graph.add(3, 4, 9);
		graph.add(3, 5, 14);
		graph.add(4, 5, 10);
		graph.add(5, 6, 2);
		graph.add(6, 7, 1);
		graph.add(6, 8, 6);
		graph.add(7, 8, 7);
		

         long start=System.nanoTime();
		
		primsMST(graph);
		
		long end=System.nanoTime();
		
		System.out.println(end-start +" ns");

	}

	private static void primsMST(UnDirectedWeightedGraph graph) {
		int[] key = new int[graph.V];
		int[] parent = new int[graph.V];

		boolean[] mset = new boolean[graph.V];

		for (int i = 0; i < graph.V; i++) {
			key[i] = Integer.MAX_VALUE;
		}

		key[0] = 0;
		parent[0] = -1;

		for (int i = 0; i < graph.V - 1; i++) {
			int u = min(key, mset, graph.V);
			mset[u] = true;
			Iterator<Node> itr = graph.adjList[u].iterator();

			while (itr.hasNext()) {
				Node node = itr.next();
				int v = node.v;
				int w = node.w;

				if (mset[v] == false && key[v] > w) {
					key[v] = w;
					parent[v] = u;

				}

			}

		}

		for (int i = 1; i < graph.V; i++) {
			System.out.println(parent[i] + "  to  " + i);

		}

	}

	private static int min(int[] key, boolean[] mset, int v) {
		int min_index = -1, min_value = Integer.MAX_VALUE;

		for (int i = 0; i < v; i++) {
			if (mset[i] == false && key[i] < min_value) {
				min_index = i;
				min_value = key[i];

			}

		}

		return min_index;
	}
}
