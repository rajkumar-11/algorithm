import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DijastraMSTAdjacency {
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

		long start = System.nanoTime();

		primsMST(graph);

		long end = System.nanoTime();

		System.out.println(end - start + " ns");

	}

	private static void primsMST(UnDirectedWeightedGraph graph) {
		// int[] parent = new int[graph.V];
		boolean[] visited = new boolean[graph.V];
		
		Arrays.fill(visited, false);

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

			Iterator<Node> itr = graph.adjList[node.vertex].iterator();
			
			System.out.println("index= "+node.vertex+" value= "+nodes[node.vertex].value);

			while (itr.hasNext())
			{
				Node nodeTemp = itr.next();

				if (visited[nodeTemp.v] == false && nodes[node.vertex].value != Integer.MAX_VALUE
						&& nodeTemp.w + nodes[node.vertex].value < nodes[nodeTemp.v].value)
				{
					queue.remove(nodes[nodeTemp.v]);

					nodes[nodeTemp.v].value = nodeTemp.w + nodes[node.vertex].value;
					nodes[nodeTemp.v].parent = node.vertex;

					queue.add(nodes[nodeTemp.v]);

				}

			}

		}

		for (int i = 1; i < graph.V; i++) {
			System.out.println(  i+ "  "+ nodes[i].value);
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
