import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class HeightOfGenericTreeFromParentArray {
	public static void main(String[] args) {
		int parent[] = {-1, 0, 0, 0, 3, 1, 1, 2};
		int n = 8;
		DirectedGraph graph = new DirectedGraph(n);
		for (int i = 1; i < n; i++)
		{
			graph.addEdge(parent[i], i);
		}
		
		int[] level = new int[n];
		determineLevel(graph, level);

		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			if(level[i]>max)
				max=level[i];
			
		}
		System.out.println("max= "+max);
		
	}
	private static void determineLevel(DirectedGraph graph, int[] level) {
	
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.V];
		visited[0] = true;
		queue.add(0);

		while (!queue.isEmpty()) {
			int j = queue.remove();
			visited[j] = true;
//			System.out.println("queue size= " + queue.size());
			Iterator<Integer> iterator = graph.adjList[j].iterator();
			while (iterator.hasNext()) {
				int x = iterator.next();
				if (visited[x] == false) {
					queue.add(x);
					level[x] = level[j] + 1;
				}
			}
		}
	
		


	}
	
}
