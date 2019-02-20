
public class graphUnionFind
{
  int V,E;
  Edge2[] edges;
  
  public graphUnionFind(int v, int e)
  {
	  this.E=e;
	  this.V=v;
	  
	   edges= new Edge2[e];
	  
	  for(int i=0;i<e;i++)
	  {
		  edges[i]= new Edge2();
		  
	  }
	  
	  
	  
  }
  
  
	
	
}
