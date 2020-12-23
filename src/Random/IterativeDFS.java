import java.util.Iterator;
import java.util.Stack;

public class IterativeDFS {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		System.out.println("Following is tht Depth first Traversal");
		boolean[] visited = new boolean[graph.V];

		for (int i = 0; i < graph.V; i++) {
			if (visited[i] == false)
				IterativeDFS(graph, visited, i);
		}
	}

	private static void IterativeDFS(DirectedGraph graph, boolean[] visited, int i) {
		Stack<Integer> stack = new Stack<>();
		stack.push(i);

		while (!stack.isEmpty()) {
			int s = stack.pop();
			
			if(visited[s]==false)
			{
				System.out.print(s+" ");
				visited[s]=true;
			}

			Iterator<Integer>itr=graph.adjList[i].iterator();
			while(itr.hasNext())
			{
				int j=itr.next();
				
				if(visited[i]==false)
				{
					stack.push(j);
				}
						
				
				
			}
			 
			
			
		}

	}

}
