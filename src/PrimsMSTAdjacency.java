import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PrimsMSTAdjacency {
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
		
		long start= System.nanoTime();

		primsMST(graph);

		long end = System.nanoTime();

		System.out.println(end - start + " ns");

	}

	private static void primsMST(UnDirectedWeightedGraph graph) {
		// int[] parent = new int[graph.V];
		boolean[] visited = new boolean[graph.V];

		NodeP[] nodes = new NodeP[graph.V];

		for (int i = 0; i < graph.V; i++) {
			nodes[i] = new NodeP(i, Integer.MAX_VALUE, -1);

		}

		nodes[0].value = 0;

		PriorityQueue<NodeP> queue = new PriorityQueue<>(graph.V, new Compare());

		for (int i = 0; i < graph.V; i++) {
			queue.add(nodes[i]);
		}

		// parent[0] = -1;

		// int V = 0;

		while (!queue.isEmpty())
		{
			NodeP node = queue.poll();

			visited[node.vertex] = true;

			@SuppressWarnings({ "unchecked", "static-access" })
			Iterator<Node> itr = graph.adjList[node.vertex].iterator();

			while (itr.hasNext()) {
				Node nodeTemp = itr.next();

				if (visited[nodeTemp.v] == false && nodeTemp.w < nodes[nodeTemp.v].value) {
					queue.remove(nodes[nodeTemp.v]);

					nodes[nodeTemp.v].value = nodeTemp.w;
					nodes[nodeTemp.v].parent = node.vertex;

					queue.add(nodes[nodeTemp.v]);

				}

			}

		}

		for (int i = 1; i < graph.V; i++) {
			System.out.println(i + " to " + nodes[i].parent);
		}

	}

	private static int getMinimum(int[] value, boolean[] visited, int v) {
		int minIndex = -1, minValue = Integer.MAX_VALUE;

		for (int i = 0; i < v; i++) {
			if (value[i] < minValue && visited[i] == false) {
				minIndex = i;
				minValue = value[i];

			}

		}

		return minIndex;
	}

}

class Compare implements Comparator<NodeP> {

	@Override
	public int compare(NodeP arg0, NodeP arg1) {

		return arg0.value - arg1.value;
	}

}

class NodeP {
	int vertex, value, parent;

	public NodeP(int vertex, int value, int parent) {
		this.vertex = vertex;
		this.value = value;
		this.parent = parent;

	}

}
