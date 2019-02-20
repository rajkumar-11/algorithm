
public class DetectCycleUsingDisjointSetNlogN {
	public static void main(String[] args) {
		int V = 3, E = 3;
		GraphEdge graph = new GraphEdge(V, E);
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		graph.edge[2].src = 2;
		graph.edge[2].dest = 0;

		if (graph.isCycleNlogN(graph) == 1) 
		{
			System.out.println("Yes there is a cycle");
		} 
		else 
		{
			System.out.println("No there is no cycle");
		}

	}

}
