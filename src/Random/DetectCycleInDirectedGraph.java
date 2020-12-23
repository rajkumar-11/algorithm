
public class DetectCycleInDirectedGraph 
{
	public static void main(String[] args)
	{
	  Graph graph= new Graph(4);
	  graph.add(0,1);
	  graph.add(1,2);
	  graph.add(2,3);
	  graph.add(2,0);
//	  graph.add(2,3);
//	  graph.add(3,3);
	  if(graph.isCyclic(4))
		  System.out.println("Graph Contains cycle");
	  else
		  System.out.println("Graph doesnt contain cycle");
		
	}

}
