import java.util.Iterator;

public class TransposeGraph 
{
public static void main(String[] args) 
{
	DirectedGraph graph= new DirectedGraph(5);
	graph.addEdge(0, 1);
	graph.addEdge(0, 4);
	graph.addEdge(0, 3);
	graph.addEdge(2, 0);
	graph.addEdge(3, 2);
	graph.addEdge(4, 1);
	graph.addEdge(4, 3);
	
	DirectedGraph graphT= tranpose(graph);
	
	for(int i=0;i<graphT.V;i++)
	{
		System.out.print(i+" -->");
		 Iterator<Integer>itr=graphT.adjList[i].iterator();
		 while(itr.hasNext())
		   {
			   int j=itr.next();
			   System.out.print(j+"-->");
			 
		
		   }
		 System.out.println();
	}
	
	
}

private static DirectedGraph tranpose(DirectedGraph graph)
{
   DirectedGraph graphT= new DirectedGraph(graph.V);
   
   for(int i=0;i<graph.V;i++)
   {
	   Iterator<Integer>itr=graph.adjList[i].iterator();
	   while(itr.hasNext())
	   {
		   int j=itr.next();
		   
	      graphT.addEdge(j, i);
	   }
	   
   }
	
	return graphT;
}
	
	
}
