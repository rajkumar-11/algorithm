import java.util.LinkedList;

public class DirectedWeightedGraph 
{
   static int V;
  static LinkedList[] adjList=null;

  public  DirectedWeightedGraph(int v)
  {
	  this.V=v;
	  adjList= new LinkedList[v];
	  
	  for(int i=0;i<v;i++)
	  {
		  adjList[i]= new LinkedList<Node>();  
	  }  
	  
  }
  
  public void addEdge(int src,int dest,int weight)
  {
	  this.adjList[src].add(new Node(dest,weight));
  }
  
  
  
	
}
