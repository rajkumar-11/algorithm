package BackTracking;

public class HamiltonianCycle {
	static int V = 5;

	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };
		hamCycle(graph);

	}

	private static void hamCycle(int[][] graph) {

		for (int i = 0; i < V; i++) {

			if (DFS(graph, i)) {
				System.out.println("The hamiltonian Cycle is possible");
				return;
			}

		}
		System.out.println("The cycle is not possible");

	}

	private static boolean DFS(int[][] graph, int src) 
	{
	    
		
		
		
		
		
		return false;
	}

}
