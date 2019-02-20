package Graph;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PrimsMST {
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

		// long start= System.nanoTime();

		primsMST(graph);

		// long end = System.nanoTime();

		// System.out.println(end - start + " ns");

	}

	private static void primsMST(WeightedGraph graph) {
		int v = graph.V;

		boolean[] visited = new boolean[graph.V];

		NodeP[] nodes = new NodeP[v];

		for (int i = 0; i < v; i++) {
			nodes[i] = new NodeP(i, -1, Integer.MAX_VALUE);

		}
		nodes[0].value = 0;

		PriorityQueue<NodeP> queue = new PriorityQueue<NodeP>(v, new compare());

		for (int i = 0; i < v; i++) {
			queue.add(nodes[i]);
		}

		while (!queue.isEmpty())
		{
//			System.out.println("here");
			NodeP nodep = queue.poll();
//			System.out.println("u =" + nodep.u);

			visited[nodep.u] = true;

			Iterator<Node> itr = graph.list[nodep.u].iterator();
			while (itr.hasNext()) {
				Node node = itr.next();

				if (visited[node.v] == false && nodes[node.v].value > node.w) {
					queue.remove(nodes[node.v]);
					nodes[node.v].parent = nodep.u;
					nodes[node.v].value = node.w;
					queue.add(nodes[node.v]);
				}

			}

		}
		for (int i = 0; i < v; i++) {
			System.out.println(nodes[i].u + " " + nodes[i].parent);

		}

	}
}

class compare implements Comparator<NodeP> {

	@Override
	public int compare(NodeP n0, NodeP n1) {
		// TODO Auto-generated method stub
		return n0.value - n1.value;
	}

}

class NodeP {
	int u, parent, value;

	public NodeP(int u, int parent, int value) {
		this.u = u;
		this.parent = parent;
		this.value = value;
	}

}
