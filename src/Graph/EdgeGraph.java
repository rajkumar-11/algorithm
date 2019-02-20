package Graph;

public class EdgeGraph 
{
	int V,E;
	Edge[]edge;
	
	public  EdgeGraph(int V,int E)
	{
	    this.V=V;
	    this.E=E;
	    this.edge= new Edge[E];
	    
	    for(int i=0;i<E;i++)
	    {
	    	this.edge[i]=new Edge();
	    }
	    			
	}


	
	
	

}
class subset
{
	int parent,rank;
	
}
