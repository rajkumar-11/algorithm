import java.util.Iterator;
import java.util.Stack;

public class StronglyConnectedComponents {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);

		System.out.println("Following are strongly connected components " + "in given graph ");
		printSCCs(graph);

	}

	private static void printSCCs(DirectedGraph graph)
	{
       boolean[] visited= new boolean[graph.V];
       
       Stack<Integer> stack= new Stack<Integer>();
       
       for(int i=0;i<graph.V;i++)
       {
    	   if(visited[i]==false)
    	   DFS(graph,visited,stack,i);
    	   
    	   
       }
       
       DirectedGraph reverseGraph = reverseDirectedGraph(graph);
    
       
       for(int i=0;i<graph.V;i++)
       {
    	   visited[i]=false;
    	   
       }
        while(!stack.isEmpty())
        {
        	int u= stack.pop();
        	
        	if(visited[u]==false)
        	{
        		DFSUtils(reverseGraph,visited,u);
        		System.out.println();
        	}
        	
        	
        	
        }
        
       
        
	}

	private static void DFSUtils(DirectedGraph graph, boolean[] visited, int u) 
	{
	  visited[u]= true;
	  Iterator<Integer>itr= graph.adjList[u].iterator();
	  while(itr.hasNext())
		{
			int j= itr.next();
			
			if(visited[j]==false)
				DFSUtils(graph, visited, j);
	
		}
	  
	  System.out.print(u+" ");
		
	}

	private static DirectedGraph reverseDirectedGraph(DirectedGraph graph) 
	{
        DirectedGraph reverseGraph= new DirectedGraph(graph.V);
        
        for(int i=0;i<graph.V;i++)
        {
        	Iterator<Integer>itr= graph.adjList[i].iterator();
        	while(itr.hasNext())
    		{
        		int j=itr.next();
        		reverseGraph.addEdge(j, i);
    		}
        	
        }
		
		
		return reverseGraph;
	}

	private static void DFS(DirectedGraph graph, boolean[] visited, Stack<Integer> stack,int i) 
	{
	   
		visited[i]=true;
		
		Iterator<Integer>itr= graph.adjList[i].iterator();
		while(itr.hasNext())
		{
			int j= itr.next();
			
			if(visited[j]==false)
				DFS(graph,visited,stack,j);
	
		}
		stack.add(i);
		
		
	}

}
