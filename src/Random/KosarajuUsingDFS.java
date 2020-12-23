import java.util.Iterator;

public class KosarajuUsingDFS 
{
public static void main(String[] args) 
{
DirectedGraph graph= new DirectedGraph(5);
graph.addEdge(0, 1);
graph.addEdge(1, 2);
graph.addEdge(2, 3);
graph.addEdge(3, 0);
graph.addEdge(2, 4);
graph.addEdge(4, 2);

if(isStronglyconnected(graph))
	System.out.println("yes");
else
	System.out.println("No");

DirectedGraph graph2= new DirectedGraph(4);
graph2.addEdge(0, 1);
graph2.addEdge(1, 2);
graph2.addEdge(2, 3);

if(isStronglyconnected(graph2))
	System.out.println("yes");
else
	System.out.println("No");
	
	
}

private static boolean isStronglyconnected(DirectedGraph graph)
{
 boolean[] visited= new boolean[graph.V];
 
 isconnected(graph,visited,0);
 boolean flag=false;
 
 for(int i=0;i<graph.V;i++)
 {
	 if(visited[i]==false)
	 {
		 return false;
	 }
	 
	 visited[i]=false;
 }
 
 DirectedGraph graphTranspose=Transpose(graph);
 
 isconnected(graphTranspose,visited,0);
 for(int i=0;i<graph.V;i++)
 {
	 if(visited[i]==false)
	 {
		 return false;
	 }
	 
	 visited[i]=false;
 }
 return true;
	
	
}

private static DirectedGraph Transpose(DirectedGraph graph) 
{
    DirectedGraph graphT= new DirectedGraph(graph.V);
    
    for(int i=0;i<graph.V;i++)
    {
    	Iterator<Integer>itr=graph.adjList[i].iterator();
    	while(itr.hasNext())
    	{
    		int j=itr.next();
    		graphT.adjList[j].add(i);
    	}
    	
    }
	
	
	return graphT;
}

private static void isconnected(DirectedGraph graph, boolean[] visited,int i) 
{
   visited[i]=true;
   
   Iterator<Integer>itr=graph.adjList[i].iterator();
   
   while(itr.hasNext())
   {
	   int j=itr.next();
	   
	   if(visited[j]==false)
	   {
		   isconnected(graph,visited,j);	   
	   }
	   
   }
   
   
	
	
	
	
}
	
	
}
