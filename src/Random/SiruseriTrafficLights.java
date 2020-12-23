import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SiruseriTrafficLights {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int src = s.nextInt();
		int dest = s.nextInt();

		int n = s.nextInt();
		int m = s.nextInt();

		int[] time = new int[n];

		for (int i = 0; i < n; i++) {
			time[i] = s.nextInt();
			// System.out.println(i+" = "+time[i]);
		}

		// System.out.println("n= "+n);

		UnDirectedWeightGraph graph = new UnDirectedWeightGraph(n);

		for (int i = 0; i < m; i++) {
			int source = s.nextInt();
			int des = s.nextInt();
			int weight = s.nextInt();

			graph.add(source - 1, des - 1, weight);

		}

		int t = getMinimumTime(graph, time, src - 1, dest - 1);
		System.out.println(t);

	}

	private static int getMinimumTime(UnDirectedWeightGraph graph, int[] time, int src, int dest) {

		NodeS[] nodes = new NodeS[graph.V];
		boolean[] visited = new boolean[graph.V];

		for (int i = 0; i < graph.V; i++) {
			nodes[i] = new NodeS(i, Integer.MAX_VALUE, -1);

		}
		nodes[src].value = 0;

		PriorityQueue<NodeS> queue = new PriorityQueue<NodeS>(graph.V, new CompareS());

		for (int i = 0; i < graph.V; i++) {
			queue.add(nodes[i]);
		}

		while (!queue.isEmpty()) {
			NodeS node = queue.poll();

			visited[node.vertex] = true;
//			System.out.println("from " + node.vertex);

			Iterator<NodeW> itr = graph.adjList[node.vertex].iterator();

			if (node.vertex == dest)
				break;

			while (itr.hasNext()) {
				NodeW nodeTemp = itr.next();

				int now = nodes[node.vertex].value;
				int temp = nodeTemp.w + nodes[node.vertex].value;
				int wait = WaitTime(node.vertex, time, now, src, dest);

//				System.out.println("to " + nodeTemp.v + " wait= " + wait);
				if (visited[nodeTemp.v] == false && nodes[node.vertex].value != Integer.MAX_VALUE
						&& temp + wait < nodes[nodeTemp.v].value) {
					// System.out.println("to "+nodeTemp.v+" wait= "+wait);
					queue.remove(nodes[nodeTemp.v]);

					nodes[nodeTemp.v].value = temp + wait;
					nodes[nodeTemp.v].parent = node.vertex;

					queue.add(nodes[nodeTemp.v]);

				}

			}


		}

		return nodes[dest].value;
	}

	private static int WaitTime(int vertex, int[] time, int now, int src, int dest) {
		// System.out.println("vertex= " + vertex);

		if (vertex == src || vertex == dest)
			return 0;
		int div = time[vertex];
		int t = now;
		int count = 0;

		while (t % div != 0) {
			t++;
			count++;

		}

		return count;
	}
}

class UnDirectedWeightGraph {
	static LinkedList[] adjList = null;
	static int V;

	public UnDirectedWeightGraph(int v) {
		this.V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<NodeW>();

		}

	}

	@SuppressWarnings("unchecked")
	void add(int u, int v, int w) {
		adjList[u].add(new NodeW(v, w));
		adjList[v].add(new NodeW(u, w));

	}

}

class NodeW {
	int v, w;

	public NodeW(int v, int w) {
		this.v = v;
		this.w = w;
	}
}

class CompareS implements Comparator<NodeS> {

	@Override
	public int compare(NodeS arg0, NodeS arg1) {

		return arg0.value - arg1.value;
	}

}

class NodeS {
	int vertex, value, parent;

	public NodeS(int vertex, int value, int parent) {
		this.vertex = vertex;
		this.value = value;
		this.parent = parent;

	}

}
