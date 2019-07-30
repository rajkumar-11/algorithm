import java.util.LinkedList;

public class Graph11 
{
  int v;
  LinkedList[] adjlist=null;
  
  public Graph11(int v)
  {
	  this.v=v;
	  this.adjlist= new LinkedList[v];
	  for(int i=0;i<v;i++)
	  {
		  this.adjlist[i]= new LinkedList<Integer>();
	  }
  }
  public void addEdge(int u,int v)
  {
	  this.adjlist[u].add(v);
	  this.adjlist[v].add(u);
	  
  }
  
	
}
