import java.util.Stack;

public class TopologicalSorting {
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.add(5, 2);
		graph.add(5, 0);
		graph.add(4, 0);
		graph.add(4, 1);
		graph.add(2, 3);
		graph.add(3, 1);
		
		System.out.println("Foll9owing is a Topological  sort of the give Graph");
		
		boolean[]visited=new boolean[6];
		Stack<Integer>stack= new Stack<>();
		
		for(int i=0;i<6;i++)
		{
		if(visited[i]==false)
		  graph.topologicalSort(i,visited,stack);
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" ");
		}

	}

}
