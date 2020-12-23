import java.util.Stack;

public class HierholzerAlgorithm {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 1);

		PrintCircuit(graph);

	}

	private static void PrintCircuit(DirectedGraph graph) {
		Stack<Integer> currentPath = new Stack<>();
		Stack<Integer> circuit = new Stack<>();

		boolean[] visited = new boolean[graph.V];

		int[] verticesSize = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			verticesSize[i] = graph.adjList[i].size();

		}

		// for (int i = 0; i < graph.V; i++) {
		// if (graph.adjList[i].size() == 0) {
		// continue;
		// } else {
		// graph.adjList[].remove(new Integer((v)));
		currentPath.add(0);

		circuitUtils(graph, 0, currentPath, circuit, verticesSize);
		// }
		// }

		while (!currentPath.isEmpty()) {
			circuit.add(currentPath.pop());
		}

		// while (!currentPath.isEmpty())
		// System.out.print(currentPath.pop() + " ");

		System.out.println("here");

		while (!circuit.isEmpty())
			System.out.print(circuit.pop() + " ");

	}

	private static void circuitUtils(DirectedGraph graph, int u, Stack<Integer> currentPath, Stack<Integer> circuit,
			int[] verticesSize) {
		// visited[u]=true;
		// if (graph.adjList[u].size() == 0)
		// {
		// int x=currentPath.pop();
		// System.out.println("x= "+x);
		// circuit.add(x);
		//
		// return;
		// }
		//

		

		while (verticesSize[u] > 0) {

			// System.out.println("size= " + verticesSize[u]);
			int v = (int) graph.adjList[u].get(0);
			currentPath.add(v);
			graph.adjList[u].remove(0);
			verticesSize[u] = verticesSize[u] - 1;
			System.out.println("u= " + u + " verticesSize[u] = " + verticesSize[u]);

			System.out.println("u= " + u + " v= " + v);

			// graph.adjList[u].remove(new Integer((v)));
			circuitUtils(graph, v, currentPath, circuit, verticesSize);

			
			if (currentPath.contains(u) && verticesSize[u] == 0)
			{
				System.out.println(currentPath.size() + " " + circuit.size());

				// if(currentPath.size()+circuit.size()==graph.V-1)
				// return;

				System.out.println("here " + " u= " + u);
				circuit.add(u);
				currentPath.remove(new Integer(u));

				return;

			}
			
			// if (currentPath.size() + circuit.size() == graph.V) {
			// return;
			// }
			// else
			// {
			// System.out.println("popping");
			// circuit.add(currentPath.pop());
			// return;
			//
			// }

		}

	}

}
