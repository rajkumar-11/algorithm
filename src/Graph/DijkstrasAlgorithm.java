package Graph;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph(9);

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

		DijkstraMST(graph);

	}

	private static void DijkstraMST(WeightedGraph graph) {
		int v = graph.V;

		boolean[] visited = new boolean[graph.V];
		NodeP[] nodes = new NodeP[graph.V];

		for (int i = 0; i < graph.V; i++) {
			nodes[i] = new NodeP(i, -1, Integer.MAX_VALUE);

		}
		nodes[0].value = 0;

		PriorityQueue<NodeP> queue = new PriorityQueue<>(new compare2());

		for (int i = 0; i < graph.V; i++) {
			queue.add(nodes[i]);
		}

		while (!queue.isEmpty()) {
			NodeP nodep = queue.poll();
			visited[nodep.u] = true;

			Iterator<Node> itr = graph.list[nodep.u].iterator();

			while (itr.hasNext()) 
			{
				Node node = itr.next();

				if (visited[node.v] == false && (nodes[node.v].value > nodes[nodep.u].value + node.w)) {
					queue.remove(nodes[node.v]);
					nodes[node.v].value = nodes[nodep.u].value + node.w;
					nodes[node.v].parent = nodep.u;
					queue.add(nodes[node.v]);

				}

			}

		}

		for (int i = 0; i < graph.V; i++) {
			System.out.println(nodes[i].u + " " + nodes[i].value + " ");

		}

	}
}

class compare2 implements Comparator<NodeP> {

	@Override
	public int compare(NodeP node, NodeP node1) {
		// TODO Auto-generated method stub
		return node.value - node1.value;
	}

}
